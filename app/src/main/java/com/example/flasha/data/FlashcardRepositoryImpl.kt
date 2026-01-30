package com.example.flasha.data

import com.example.flasha.interfaces.FlashcardRepository

/**
 * Concrete implementation of the FlashcardRepository interface.
 * This implementation uses a simple in-memory list as the data source.
 */
class FlashcardRepositoryImpl : FlashcardRepository {

    // In-memory database of flashcards
    private val allFlashcards = listOf(
        FlashcardDT("gehen", "to go", "A1", "Verbs"),
        FlashcardDT("haben", "to have", "A1", "Verbs"),
        FlashcardDT("sein", "to be", "A1", "Verbs"),
        FlashcardDT("der Tisch", "the table", "A1", "Nouns"),
        FlashcardDT("das Buch", "the book", "A1", "Nouns"),
        FlashcardDT("lesen", "to read", "A2", "Verbs"),
        FlashcardDT("schreiben", "to write", "A2", "Verbs"),
        FlashcardDT("die Prüfung", "the exam", "B1", "Nouns"),
        FlashcardDT("die Regierung", "the government", "B2", "Nouns")
    )

    override fun getLevels(): List<String> {
        return allFlashcards.map { it.level }.distinct().sorted()
    }

    override fun getCategoriesForLevel(level: String): List<String> {
        return allFlashcards.filter { it.level == level }.map { it.category }.distinct().sorted()
    }

    override fun getFlashcards(level: String, category: String): List<FlashcardDT> {
        return allFlashcards.filter { it.level == level && it.category == category }
    }
}
