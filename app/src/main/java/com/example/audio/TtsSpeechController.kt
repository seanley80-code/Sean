package com.example.audio

import android.content.Context
import android.content.Intent
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import com.example.model.ConversationLine
import com.example.model.LanguageType
import com.example.model.SpeechSpeed
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

enum class TtsLanguageStatus {
    CHECKING,
    READY,
    NEEDS_VOICE_DATA,
    UNAVAILABLE
}

data class TtsPlaybackState(
    val isEngineReady: Boolean = false,
    val activePhraseId: String? = null,
    val activeLanguage: LanguageType? = null,
    val isPlayingSequence: Boolean = false,
    val languageStatus: Map<LanguageType, TtsLanguageStatus> = LanguageType.entries.associateWith {
        TtsLanguageStatus.CHECKING
    },
    val warningMessage: String? = null
)

class TtsSpeechController(context: Context) {

    private val appContext = context.applicationContext
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    private val _playbackState = MutableStateFlow(TtsPlaybackState())
    val playbackState: StateFlow<TtsPlaybackState> = _playbackState.asStateFlow()

    private var tts: TextToSpeech? = null
    private var sequenceJob: Job? = null
    private val pendingUtterances = ConcurrentHashMap<String, CompletableDeferred<Boolean>>()

    init {
        initTts()
    }

    private fun initTts() {
        tts = TextToSpeech(appContext) { status ->
            if (status == TextToSpeech.SUCCESS) {
                configureListener()
                refreshLanguageAvailability()
            } else {
                _playbackState.update {
                    it.copy(
                        isEngineReady = false,
                        languageStatus = LanguageType.entries.associateWith { TtsLanguageStatus.UNAVAILABLE },
                        warningMessage = "ឧបករណ៍នេះមិនទាន់អាចបើកប្រព័ន្ធសំឡេង TTS បានទេ។"
                    )
                }
            }
        }
    }

    private fun configureListener() {
        tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
            override fun onStart(utteranceId: String?) = Unit

            override fun onDone(utteranceId: String?) {
                if (utteranceId != null) {
                    pendingUtterances.remove(utteranceId)?.complete(true)
                }
                scope.launch {
                    if (sequenceJob?.isActive != true) {
                        _playbackState.update {
                            it.copy(activePhraseId = null, activeLanguage = null)
                        }
                    }
                }
            }

            @Deprecated("Deprecated in Java")
            override fun onError(utteranceId: String?) {
                onUtteranceError(utteranceId)
            }

            override fun onError(utteranceId: String?, errorCode: Int) {
                onUtteranceError(utteranceId)
            }
        })
    }

    private fun onUtteranceError(utteranceId: String?) {
        if (utteranceId != null) {
            pendingUtterances.remove(utteranceId)?.complete(false)
        }
        scope.launch {
            if (sequenceJob?.isActive != true) {
                _playbackState.update {
                    it.copy(activePhraseId = null, activeLanguage = null)
                }
            }
        }
    }

    fun refreshLanguageAvailability() {
        val engine = tts ?: return
        val statusMap = LanguageType.entries.associateWith { lang ->
            when (engine.isLanguageAvailable(lang.locale)) {
                TextToSpeech.LANG_AVAILABLE,
                TextToSpeech.LANG_COUNTRY_AVAILABLE,
                TextToSpeech.LANG_COUNTRY_VAR_AVAILABLE -> TtsLanguageStatus.READY
                TextToSpeech.LANG_MISSING_DATA -> TtsLanguageStatus.NEEDS_VOICE_DATA
                else -> TtsLanguageStatus.UNAVAILABLE
            }
        }
        _playbackState.update {
            it.copy(
                isEngineReady = true,
                languageStatus = statusMap
            )
        }
    }

    fun speakSingle(
        phraseId: String,
        text: String,
        language: LanguageType,
        speed: SpeechSpeed
    ) {
        val current = _playbackState.value
        if (current.activePhraseId == phraseId && current.activeLanguage == language && !current.isPlayingSequence) {
            stop()
            return
        }
        cancelSequenceOnly()
        scope.launch {
            speakInternal(phraseId = phraseId, text = text, language = language, speed = speed)
        }
    }

    fun speakAllLanguages(
        line: ConversationLine,
        speed: SpeechSpeed
    ) {
        val current = _playbackState.value
        if (current.isPlayingSequence && current.activePhraseId == line.id) {
            stop()
            return
        }
        cancelSequenceOnly()
        sequenceJob = scope.launch {
            _playbackState.update { it.copy(isPlayingSequence = true, warningMessage = null) }
            val order = listOf(LanguageType.ENGLISH, LanguageType.CHINESE, LanguageType.KHMER)
            for ((index, lang) in order.withIndex()) {
                val spoken = speakAndAwait(
                    phraseId = line.id,
                    text = line.translationFor(lang).text,
                    language = lang,
                    speed = speed
                )
                if (index < order.lastIndex) {
                    delay(if (spoken) 350L else 120L)
                }
            }
            _playbackState.update {
                it.copy(
                    activePhraseId = null,
                    activeLanguage = null,
                    isPlayingSequence = false
                )
            }
        }
    }

    fun speakDialogue(
        lines: List<ConversationLine>,
        language: LanguageType,
        speed: SpeechSpeed
    ) {
        if (lines.isEmpty()) return
        if (_playbackState.value.isPlayingSequence) {
            stop()
            return
        }
        cancelSequenceOnly()
        sequenceJob = scope.launch {
            _playbackState.update { it.copy(isPlayingSequence = true, warningMessage = null) }
            for ((index, line) in lines.withIndex()) {
                val spoken = speakAndAwait(
                    phraseId = line.id,
                    text = line.translationFor(language).text,
                    language = language,
                    speed = speed
                )
                if (!spoken) break
                if (index < lines.lastIndex) {
                    delay(420L)
                }
            }
            _playbackState.update {
                it.copy(
                    activePhraseId = null,
                    activeLanguage = null,
                    isPlayingSequence = false
                )
            }
        }
    }

    private fun speakInternal(
        phraseId: String,
        text: String,
        language: LanguageType,
        speed: SpeechSpeed
    ): CompletableDeferred<Boolean>? {
        val engine = tts
        if (engine == null || !_playbackState.value.isEngineReady) {
            _playbackState.update {
                it.copy(warningMessage = "កំពុងរៀបចំប្រព័ន្ធសំឡេង... សូមសាកល្បងម្តងទៀត។")
            }
            return null
        }

        val langResult = engine.setLanguage(language.locale)
        if (langResult == TextToSpeech.LANG_MISSING_DATA || langResult == TextToSpeech.LANG_NOT_SUPPORTED) {
            refreshLanguageAvailability()
            _playbackState.update {
                it.copy(
                    activePhraseId = null,
                    activeLanguage = null,
                    warningMessage = "មិនទាន់មានទិន្នន័យសំឡេង ${language.khmerName} (${language.locale.toLanguageTag()}) នៅលើទូរស័ព្ទនេះទេ។ សូមបើកការកំណត់ TTS ដើម្បីទាញយកសំឡេង។"
                )
            }
            return null
        }

        engine.setSpeechRate(speed.rate)
        engine.setPitch(1.0f)

        val utteranceId = UUID.randomUUID().toString()
        val deferred = CompletableDeferred<Boolean>()
        pendingUtterances[utteranceId] = deferred

        _playbackState.update {
            it.copy(
                activePhraseId = phraseId,
                activeLanguage = language,
                warningMessage = null
            )
        }

        val speakResult = engine.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId)
        if (speakResult == TextToSpeech.ERROR) {
            pendingUtterances.remove(utteranceId)
            deferred.complete(false)
            _playbackState.update {
                it.copy(
                    activePhraseId = null,
                    activeLanguage = null,
                    warningMessage = "មិនអាចចាក់សំឡេង ${language.khmerName} បានទេ។"
                )
            }
            return null
        }
        return deferred
    }

    private suspend fun speakAndAwait(
        phraseId: String,
        text: String,
        language: LanguageType,
        speed: SpeechSpeed
    ): Boolean {
        val deferred = speakInternal(phraseId, text, language, speed) ?: return false
        return deferred.await()
    }

    private fun cancelSequenceOnly() {
        sequenceJob?.cancel()
        sequenceJob = null
        pendingUtterances.values.forEach { it.complete(false) }
        pendingUtterances.clear()
        tts?.stop()
    }

    fun stop() {
        cancelSequenceOnly()
        _playbackState.update {
            it.copy(
                activePhraseId = null,
                activeLanguage = null,
                isPlayingSequence = false
            )
        }
    }

    fun clearWarning() {
        _playbackState.update { it.copy(warningMessage = null) }
    }

    fun openTtsSettings(context: Context) {
        val intent = Intent("com.android.settings.TTS_SETTINGS").apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        runCatching {
            context.startActivity(intent)
        }
    }

    fun release() {
        cancelSequenceOnly()
        tts?.shutdown()
        tts = null
    }
}
