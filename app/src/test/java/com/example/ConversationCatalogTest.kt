package com.example

import com.example.data.ConversationCatalog
import com.example.model.SpeechSpeed
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ConversationCatalogTest {

    @Test
    fun allCategoriesHaveTrilingualPhrasesWithReadings() {
        assertEquals(8, ConversationCatalog.categories.size)
        assertTrue(ConversationCatalog.allPhrases.isNotEmpty())

        ConversationCatalog.allPhrases.forEach { line ->
            assertFalse("Missing English text for ${line.id}", line.english.text.isBlank())
            assertFalse("Missing English reading for ${line.id}", line.english.romanizedOrPinyin.isBlank())
            assertFalse("Missing English Khmer phonetic for ${line.id}", line.english.khmerPhonetic.isNullOrBlank())

            assertFalse("Missing Chinese text for ${line.id}", line.chinese.text.isBlank())
            assertFalse("Missing Chinese pinyin for ${line.id}", line.chinese.romanizedOrPinyin.isBlank())
            assertFalse("Missing Chinese Khmer phonetic for ${line.id}", line.chinese.khmerPhonetic.isNullOrBlank())

            assertFalse("Missing Khmer text for ${line.id}", line.khmer.text.isBlank())
            assertFalse("Missing Khmer reading for ${line.id}", line.khmer.romanizedOrPinyin.isBlank())
        }
    }

    @Test
    fun searchMatchesEnglishChinesePinyinAndKhmer() {
        assertTrue(ConversationCatalog.searchPhrases("morning").any { it.id == "gr_1" })
        assertTrue(ConversationCatalog.searchPhrases("早上好").any { it.id == "gr_1" })
        assertTrue(ConversationCatalog.searchPhrases("Zǎoshang").any { it.id == "gr_1" })
        assertTrue(ConversationCatalog.searchPhrases("អរុណសួស្តី").any { it.id == "gr_1" })
    }

    @Test
    fun threeSpeechSpeedsAreOrderedSlowNormalFast() {
        assertEquals(3, SpeechSpeed.entries.size)
        assertTrue(SpeechSpeed.SLOW.rate < SpeechSpeed.NORMAL.rate)
        assertTrue(SpeechSpeed.NORMAL.rate < SpeechSpeed.FAST.rate)
    }
}
