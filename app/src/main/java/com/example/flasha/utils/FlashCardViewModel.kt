import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class FlashcardViewModel : ViewModel() {

    var category by mutableStateOf("Verb")
        private set

    var level by mutableStateOf("A1")
        private set

    var flashCards by mutableStateOf<List<FlashcardDT>>(flashcardList)
        private set

    // ✅ Remove card by german word
    fun removeCard(germanWord: String) {
        flashCards = flashCards.filterNot { it.german == germanWord }
    }

    // ✅ Add a new card
    fun addCard(card: FlashcardDT) {
        flashCards = flashCards + card
    }

    // (Optional) Update filters
    fun setCardsCategory(newCategory: String) {
        category = newCategory
    }

    fun setCardsLevel(newLevel: String) {
        level = newLevel
    }
}
