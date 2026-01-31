package com.example.flasha

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flasha.ui.theme.GermanBlack
import com.example.flasha.ui.theme.GermanGold
import com.example.flasha.ui.theme.GermanRed
import com.example.flasha.utils.FlashcardViewModel

data class CERFlevel(val title: String, val description: String)

@Composable
fun ChooseLevelScreen(
  navController: NavController,
  modifier: Modifier = Modifier,
  vm: FlashcardViewModel
) {
  val levels = listOf(
    CERFlevel("A1", "Beginner - Basic phrases and expressions"),
    CERFlevel("A2", "Elementary - Simple communication"),
    CERFlevel("B1", "Intermediate - Independent use"),
    CERFlevel("B2", "Upper Intermediate - Complex texts"),
  )

  Column(
    modifier = modifier
      .fillMaxSize()
      .background(
        brush = Brush.verticalGradient(
          colors = listOf(GermanBlack, GermanRed, GermanGold)
        )
      )
      .padding(16.dp)
      .verticalScroll(rememberScrollState()),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    // Top bar with back button
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 16.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      IconButton(onClick = { navController.popBackStack() }) {
        Icon(
          imageVector = Icons.AutoMirrored.Filled.ArrowBack,
          contentDescription = "Back",
          tint = Color.White
        )
      }

      Spacer(modifier = Modifier.width(8.dp))

      Text(
        text = "Choose Your Level",
        color = Color.White,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold
      )
    }

    // Level cards
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