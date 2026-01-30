package com.example.flasha.interfaces

import com.example.flasha.Flashcard // Assuming Flashcard data class exists

/**
 * Interface (contract) for data operations related to flashcards.
 * This decouples the ViewModel from the underlying data source (e.g., in-memory list, database, or network).
 */
interface FlashcardRepository {
    /**
     * Retrieves a list of all available German proficiency levels.
     */
    fun getLevels(): List<String>

    /**
     * Retrieves a list of categories for a given proficiency level.
     * @param level The proficiency level (e.g., "A1").
     */
    fun getCategoriesForLevel(level: String): List<String>

    /**
     * Retrieves a list of flashcards for a given level and category.
     * @param level The proficiency level.
     * @param category The vocabulary category.
     */
    fun getFlashcards(level: String, category: String): List<Flashcard>
}
