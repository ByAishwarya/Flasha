import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class FlashcardViewModel : ViewModel() {
    var category by mutableStateOf("Verb")
    var level by mutableStateOf("A1")
}
