package com.example.model

data class PhraseTranslation(
    val text: String,
    val romanizedOrPinyin: String,
    val khmerPhonetic: String? = null
)

data class ConversationLine(
    val id: String,
    val categoryId: String,
    val speakerRoleKm: String,
    val speakerRoleEn: String,
    val english: PhraseTranslation,
    val chinese: PhraseTranslation,
    val khmer: PhraseTranslation,
    val contextNoteKm: String? = null
) {
    fun translationFor(language: LanguageType): PhraseTranslation = when (language) {
        LanguageType.ENGLISH -> english
        LanguageType.CHINESE -> chinese
        LanguageType.KHMER -> khmer
    }

    fun matchesQuery(query: String): Boolean {
        val q = query.trim().lowercase()
        if (q.isEmpty()) return true
        return english.text.lowercase().contains(q) ||
            english.romanizedOrPinyin.lowercase().contains(q) ||
            (english.khmerPhonetic?.lowercase()?.contains(q) == true) ||
            chinese.text.lowercase().contains(q) ||
            chinese.romanizedOrPinyin.lowercase().contains(q) ||
            (chinese.khmerPhonetic?.lowercase()?.contains(q) == true) ||
            khmer.text.lowercase().contains(q) ||
            khmer.romanizedOrPinyin.lowercase().contains(q) ||
            speakerRoleKm.lowercase().contains(q)
    }
}

enum class TopicIconType {
    GREETINGS,
    DINING,
    SHOPPING,
    TRAVEL,
    WORK,
    HEALTH,
    PHONE_WIFI,
    DAILY_LIFE
}

data class ConversationCategory(
    val id: String,
    val titleKm: String,
    val titleEn: String,
    val titleZh: String,
    val subtitleKm: String,
    val iconType: TopicIconType,
    val phrases: List<ConversationLine>
)
