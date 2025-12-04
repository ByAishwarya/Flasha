import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun ChooseCategoryScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Choose a Category",
            color = Color.Black,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "What would you like to practice?",
            color = Color.Gray,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Grid of category cards
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // First Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CategoryCard(
                    title = "Noun",
                    description = "Things, people, and places",
                    iconColor = Color(0xFF2196F3), // Blue
                    icon = Icons.Default.Star,
                    modifier = Modifier.weight(1f),
                    onClick = { /* TODO: Navigate to flashcard screen */ }
                )

                CategoryCard(
                    title = "Verb",
                    description = "Actions and activities",
                    iconColor = Color(0xFF9C27B0), // Purple
                    icon = Icons.Default.Star,
                    modifier = Modifier.weight(1f),
                    onClick = { /* TODO: Navigate to flashcard screen */ }
                )
            }

            // Second Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CategoryCard(
                    title = "Adjective",
                    description = "Descriptive words",
                    iconColor = Color(0xFFE91E63), // Pink
                    icon = Icons.Default.Star,
                    modifier = Modifier.weight(1f),
                    onClick = { /* TODO: Navigate to flashcard screen */ }
                )

                CategoryCard(
                    title = "Phrase",
                    description = "Common expressions",
                    iconColor = Color(0xFF4CAF50), // Green
                    icon = Icons.Default.Star,
                    modifier = Modifier.weight(1f),
                    onClick = { /* TODO: Navigate to flashcard screen */ }
                )
            }
        }
    }
}
