package com.example.data

import com.example.model.ConversationCategory
import com.example.model.ConversationLine

object ConversationCatalog {
    val categories: List<ConversationCategory> = listOf(
        greetingsCategory,
        diningCategory,
        shoppingCategory,
        travelCategory,
        workCategory,
        healthCategory,
        phoneWifiCategory,
        dailyLifeCategory
    )

    val allPhrases: List<ConversationLine> = categories.flatMap { it.phrases }

    fun getCategoryById(categoryId: String): ConversationCategory? =
        categories.find { it.id == categoryId }

    fun searchPhrases(query: String): List<ConversationLine> {
        val trimmed = query.trim()
        if (trimmed.isEmpty()) return emptyList()
        return allPhrases.filter { it.matchesQuery(trimmed) }
    }

    fun getDailySpotlight(): ConversationLine =
        allPhrases.lastOrNull() ?: greetingsCategory.phrases.first()
}
