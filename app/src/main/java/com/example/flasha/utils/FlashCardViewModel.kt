package com.example.flasha.utils

import androidx.lifecycle.ViewModel
import com.example.flasha.data.FlashcardDT
import com.example.flasha.interfaces.FlashcardRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FlashcardViewModel(private val repository: FlashcardRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(FlashcardUiState())
    val uiState: StateFlow<FlashcardUiState> = _uiState.asStateFlow()

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        val levels = repository.getLevels()
        _uiState.update {
            it.copy(levels = levels, selectedLevel = levels.firstOrNull() ?: "")
        }
        updateCategories()
        updateFlashcards()
    }

    fun selectLevel(level: String) {
        _uiState.update { it.copy(selectedLevel = level) }
        updateCategories()
    }

    fun selectCategory(category: String) {
        _uiState.update { it.copy(selectedCategory = category) }
        updateFlashcards()
    }

    private fun updateCategories() {
        val categories = repository.getCategoriesForLevel(uiState.value.selectedLevel)
        _uiState.update {
            it.copy(categories = categories, selectedCategory = categories.firstOrNull() ?: "")
        }
    }

    private fun updateFlashcards() {
        val flashcards = repository.getFlashcards(uiState.value.selectedLevel, uiState.value.selectedCategory)
        _uiState.update { it.copy(flashcards = flashcards) }
    }
}

data class FlashcardUiState(
    val levels: List<String> = emptyList(),
    val categories: List<String> = emptyList(),
    val flashcards: List<FlashcardDT> = emptyList(),
    val selectedLevel: String = "",
    val selectedCategory: String = ""
)