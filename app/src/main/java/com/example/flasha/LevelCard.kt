package com.example.flasha

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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

@Composable
fun LevelCard(
  navController: NavController,
  modifier: Modifier = Modifier,
  level: CERFlevel,
  vm: FlashcardViewModel
) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .clickable {
        vm.selectLevel(level.title)
        navController.navigate("choose_category")
      }
      .padding(vertical = 8.dp),
    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White)
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      // Icon/Badge
      Box(
        modifier = Modifier
          .size(60.dp)
          .background(
            Color(0xFFFFF59D),
            shape = RoundedCornerShape(12.dp)
          ),
        contentAlignment = Alignment.Center
      ) {
        Column(
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "Star",
            tint = Color(0xFFFFA000),
            modifier = Modifier.size(24.dp)
          )
          Text(
            text = level.title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
          )
        }
      }

      Spacer(modifier = Modifier.width(16.dp))

      // Text Content
      Column {
        Text(
          text = level.title,
          color = Color.Black,
          fontSize = 20.sp,
          fontWeight = FontWeight.Bold
        )
        Text(
          text = level.description,
          color = Color.Gray,
          fontSize = 14.sp,
          lineHeight = 18.sp
        )
      }
    }
  }
}