fun getFilteredFlashcards(
    flashcards: List<FlashcardDT> = flashcardList,
    level: String,
    category: String
): List<FlashcardDT> {
    return flashcards
        .filter { it.level == level && it.category == category }// randomizes the order
}