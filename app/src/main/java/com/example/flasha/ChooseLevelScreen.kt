import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class CERFlevel (val title: String, val description: String);

@Composable
fun ChooseLevelScreen(navController: NavController, modifier: Modifier = Modifier) {
  val levels = listOf<CERFlevel>(
    CERFlevel("A1", "Beginner - Basic phrases\nand expressions"),
    CERFlevel("A2", "Beginner - Basic phrases\nand expressions"),
    CERFlevel("B1", "Intermediate - Basic phrases\nand expressions"),
    CERFlevel("B2", "Intermediate - Basic phrases\nand expressions"),
    CERFlevel("B2", "Intermediate - Basic phrases\nand expressions"),
  )
  Column(
    modifier = modifier
      .fillMaxSize()
      .padding(30.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(
      text = "Choose Your Level",
      color = Color.Black,
      fontSize = 22.sp,
      fontWeight = FontWeight.Bold,
      modifier = Modifier.padding(bottom = 24.dp)
    )
    for (lvl in levels) {
      LevelCard(navController, modifier,lvl)
    }
  }
}