package com.example.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.model.SpeechSpeed
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.sontanaDataStore: DataStore<Preferences> by preferencesDataStore(
    name = "sontana_preferences"
)

class UserPreferencesRepository(private val context: Context) {

    private object Keys {
        val SPEECH_SPEED = stringPreferencesKey("speech_speed")
        val FAVORITE_IDS = stringSetPreferencesKey("favorite_phrase_ids")
        val SHOW_READING_TEXT = booleanPreferencesKey("show_reading_text")
        val SHOW_KHMER_PHONETIC = booleanPreferencesKey("show_khmer_phonetic")
    }

    val speechSpeed: Flow<SpeechSpeed> = context.sontanaDataStore.data.map { prefs ->
        val raw = prefs[Keys.SPEECH_SPEED]
        SpeechSpeed.entries.find { it.name == raw } ?: SpeechSpeed.NORMAL
    }

    val favoriteIds: Flow<Set<String>> = context.sontanaDataStore.data.map { prefs ->
        prefs[Keys.FAVORITE_IDS] ?: emptySet()
    }

    val showReadingText: Flow<Boolean> = context.sontanaDataStore.data.map { prefs ->
        prefs[Keys.SHOW_READING_TEXT] ?: true
    }

    val showKhmerPhonetic: Flow<Boolean> = context.sontanaDataStore.data.map { prefs ->
        prefs[Keys.SHOW_KHMER_PHONETIC] ?: true
    }

    suspend fun setSpeechSpeed(speed: SpeechSpeed) {
        context.sontanaDataStore.edit { prefs ->
            prefs[Keys.SPEECH_SPEED] = speed.name
        }
    }

    suspend fun toggleFavorite(phraseId: String) {
        context.sontanaDataStore.edit { prefs ->
            val current = prefs[Keys.FAVORITE_IDS] ?: emptySet()
            prefs[Keys.FAVORITE_IDS] = if (phraseId in current) {
                current - phraseId
            } else {
                current + phraseId
            }
        }
    }

    suspend fun setShowReadingText(show: Boolean) {
        context.sontanaDataStore.edit { prefs ->
            prefs[Keys.SHOW_READING_TEXT] = show
        }
    }

    suspend fun setShowKhmerPhonetic(show: Boolean) {
        context.sontanaDataStore.edit { prefs ->
            prefs[Keys.SHOW_KHMER_PHONETIC] = show
        }
    }
}
