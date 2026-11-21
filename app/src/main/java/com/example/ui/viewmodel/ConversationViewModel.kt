package com.example.ui.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.audio.TtsPlaybackState
import com.example.audio.TtsSpeechController
import com.example.data.ConversationCatalog
import com.example.data.UserPreferencesRepository
import com.example.model.ConversationCategory
import com.example.model.ConversationLine
import com.example.model.LanguageType
import com.example.model.SpeechSpeed
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class ConversationUiState(
    val categories: List<ConversationCategory> = ConversationCatalog.categories,
    val dailySpotlight: ConversationLine = ConversationCatalog.getDailySpotlight(),
    val searchQuery: String = "",
    val searchResults: List<ConversationLine> = emptyList(),
    val speechSpeed: SpeechSpeed = SpeechSpeed.NORMAL,
    val favoriteIds: Set<String> = emptySet(),
    val favoritePhrases: List<ConversationLine> = emptyList(),
    val showReadingText: Boolean = true,
    val showKhmerPhonetic: Boolean = true,
    val playbackState: TtsPlaybackState = TtsPlaybackState(),
    val practiceCategoryId: String = "all"
) {
    val practicePhrases: List<ConversationLine>
        get() = when (practiceCategoryId) {
            "all" -> ConversationCatalog.allPhrases
            "favorites" -> favoritePhrases
            else -> ConversationCatalog.getCategoryById(practiceCategoryId)?.phrases
                ?: ConversationCatalog.allPhrases
        }
}

class ConversationViewModel(application: Application) : AndroidViewModel(application) {

    private val prefsRepo = UserPreferencesRepository(application.applicationContext)
    private val ttsController = TtsSpeechController(application.applicationContext)

    private val searchQueryFlow = MutableStateFlow("")
    private val practiceCategoryIdFlow = MutableStateFlow("all")

    val uiState: StateFlow<ConversationUiState> = combine(
        searchQueryFlow,
        prefsRepo.speechSpeed,
        prefsRepo.favoriteIds,
        prefsRepo.showReadingText,
        prefsRepo.showKhmerPhonetic,
        ttsController.playbackState,
        practiceCategoryIdFlow
    ) { values ->
        val query = values[0] as String
        val speed = values[1] as SpeechSpeed
        @Suppress("UNCHECKED_CAST")
        val favIds = values[2] as Set<String>
        val showReading = values[3] as Boolean
        val showKhmerPhonetic = values[4] as Boolean
        val playback = values[5] as TtsPlaybackState
        val practiceCatId = values[6] as String

        val favPhrases = ConversationCatalog.allPhrases.filter { it.id in favIds }
        val results = if (query.isBlank()) emptyList() else ConversationCatalog.searchPhrases(query)

        ConversationUiState(
            categories = ConversationCatalog.categories,
            dailySpotlight = ConversationCatalog.getDailySpotlight(),
            searchQuery = query,
            searchResults = results,
            speechSpeed = speed,
            favoriteIds = favIds,
            favoritePhrases = favPhrases,
            showReadingText = showReading,
            showKhmerPhonetic = showKhmerPhonetic,
            playbackState = playback,
            practiceCategoryId = practiceCatId
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = ConversationUiState()
    )

    fun updateSearchQuery(query: String) {
        searchQueryFlow.value = query
    }

    fun selectSpeechSpeed(speed: SpeechSpeed) {
        viewModelScope.launch {
            prefsRepo.setSpeechSpeed(speed)
        }
    }

    fun toggleFavorite(phraseId: String) {
        viewModelScope.launch {
            prefsRepo.toggleFavorite(phraseId)
        }
    }

    fun setShowReadingText(show: Boolean) {
        viewModelScope.launch {
            prefsRepo.setShowReadingText(show)
        }
    }

    fun setShowKhmerPhonetic(show: Boolean) {
        viewModelScope.launch {
            prefsRepo.setShowKhmerPhonetic(show)
        }
    }

    fun selectPracticeCategory(categoryId: String) {
        practiceCategoryIdFlow.value = categoryId
    }

    fun speakPhrase(line: ConversationLine, language: LanguageType) {
        val text = line.translationFor(language).text
        ttsController.speakSingle(
            phraseId = line.id,
            text = text,
            language = language,
            speed = uiState.value.speechSpeed
        )
    }

    fun speakAllThree(line: ConversationLine) {
        ttsController.speakAllLanguages(
            line = line,
            speed = uiState.value.speechSpeed
        )
    }

    fun speakCategoryDialogue(categoryId: String, language: LanguageType) {
        val lines = ConversationCatalog.getCategoryById(categoryId)?.phrases ?: return
        ttsController.speakDialogue(
            lines = lines,
            language = language,
            speed = uiState.value.speechSpeed
        )
    }

    fun stopAudio() {
        ttsController.stop()
    }

    fun clearWarning() {
        ttsController.clearWarning()
    }

    fun refreshTtsAvailability() {
        ttsController.refreshLanguageAvailability()
    }

    fun openTtsSettings(context: Context) {
        ttsController.openTtsSettings(context)
    }

    override fun onCleared() {
        super.onCleared()
        ttsController.release()
    }
}
