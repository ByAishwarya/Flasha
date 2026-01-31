package com.example.flasha

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
import com.example.flasha.utils.FlashcardViewModel

data class CERFlevel(val title: String, val description: String)

@Composable
fun ChooseLevelScreen(
  navController: NavController,
  modifier: Modifier = Modifier,
  vm: FlashcardViewModel
) {
  val levels = listOf(
    CERFlevel("A1", "Beginner - Basic phrases\nand expressions"),
    CERFlevel("A2", "Elementary - Simple communication"),
    CERFlevel("B1", "Intermediate - Independent use"),
    CERFlevel("B2", "Upper Intermediate - Complex texts"),
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

    NavigateButton(
      text = "Go to Flashcards",
      route = "list",
      navController = navController
    )

    for (lvl in levels) {
      LevelCard(
        navController = navController,
        modifier = modifier,
        level = lvl,
        vm = vm
      )
    }
  }
}