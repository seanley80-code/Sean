package com.example.model

import java.util.Locale

enum class LanguageType(
    val shortCode: String,
    val khmerName: String,
    val englishName: String,
    val nativeName: String,
    val locale: Locale
) {
    ENGLISH(
        shortCode = "EN",
        khmerName = "អង់គ្លេស",
        englishName = "English",
        nativeName = "English",
        locale = Locale.US
    ),
    CHINESE(
        shortCode = "中文",
        khmerName = "ចិន",
        englishName = "Chinese",
        nativeName = "中文",
        locale = Locale.SIMPLIFIED_CHINESE
    ),
    KHMER(
        shortCode = "ខ្មែរ",
        khmerName = "ខ្មែរ",
        englishName = "Khmer",
        nativeName = "ភាសាខ្មែរ",
        locale = Locale("km", "KH")
    )
}

enum class SpeechSpeed(
    val rate: Float,
    val khmerLabel: String,
    val englishLabel: String,
    val rateLabel: String
) {
    SLOW(
        rate = 0.60f,
        khmerLabel = "យឺត",
        englishLabel = "Slow",
        rateLabel = "0.6x"
    ),
    NORMAL(
        rate = 1.00f,
        khmerLabel = "ធម្មតា",
        englishLabel = "Normal",
        rateLabel = "1.0x"
    ),
    FAST(
        rate = 1.45f,
        khmerLabel = "លឿន",
        englishLabel = "Fast",
        rateLabel = "1.45x"
    )
}
