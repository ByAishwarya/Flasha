package com.example.flasha

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
fun ChooseCategoryScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    vm: FlashcardViewModel
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top bar with back button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Choose a Category",
                color = Color.Black,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Text(
            text = "What would you like to practice?",
            color = Color.Gray,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CategoryCard(
                    title = "Nouns",
                    description = "Things, people, and places",
                    iconColor = Color(0xFF2196F3),
                    icon = Icons.Default.Star,
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = 150.dp),
                    onClick = {
                        vm.selectCategory("Nouns")
                        navController.navigate("flashcards")
                    }
                )

                CategoryCard(
                    title = "Verbs",
                    description = "Actions and activities",
                    iconColor = Color(0xFF9C27B0),
                    icon = Icons.Default.Star,
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = 150.dp),
                    onClick = {
                        vm.selectCategory("Verbs")
                        navController.navigate("flashcards")
                    }
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CategoryCard(
                    title = "Adjectives",
                    description = "Descriptive words",
                    iconColor = Color(0xFFE91E63),
                    icon = Icons.Default.Star,
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = 150.dp),
                    onClick = {
                        vm.selectCategory("Adjectives")
                        navController.navigate("flashcards")
                    }
                )

                CategoryCard(
                    title = "Phrases",
                    description = "Common expressions",
                    iconColor = Color(0xFF4CAF50),
                    icon = Icons.Default.Star,
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = 150.dp),
                    onClick = {
                        vm.selectCategory("Phrases")
                        navController.navigate("flashcards")
                    }
                )
            }
        }
    }
}