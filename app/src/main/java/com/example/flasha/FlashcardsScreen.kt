package com.example.flasha

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class Flashcard(
    val german: String,
    val english: String
)

@Composable
fun FlashcardsScreen(navController: NavController, category: String) {
    // Mock sample data (replace with real nouns/verbs/etc later)
    val flashcards = listOf(
        Flashcard("der Hund", "the dog"),
        Flashcard("die Katze", "the cat"),
        Flashcard("laufen", "to run"),
        Flashcard("schön", "beautiful")
    )

    var currentIndex by remember { mutableStateOf(0) }
    var flipped by remember { mutableStateOf(false) }

    val currentCard = flashcards[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // TOP BAR — Centered counter
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Back Button (left)
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }

            // Centered counter
            val index = ""
            Text(
                text = "Card ${index + 1} of ${flashcards.size}",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.weight(1f),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            // Placeholder to balance layout (right side)
            Spacer(modifier = Modifier.width(48.dp))
        }

        // SPACER
        Box(modifier = Modifier.height(40.dp))

        // FLASHCARD (with flip animation)
        FlashcardView(
            frontText = currentCard.german,
            backText = currentCard.english,
            flipped = flipped,
            onTap = { flipped = !flipped }
        )

        // NAV BUTTONS
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                enabled = currentIndex > 0,
                onClick = {
                    flipped = false
                    currentIndex--
                }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Previous",
                    tint = if (currentIndex > 0) Color.Black else Color.Gray
                )
            }

            IconButton(
                enabled = currentIndex < flashcards.size - 1,
                onClick = {
                    flipped = false
                    currentIndex++
                }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Next",
                    tint = if (currentIndex < flashcards.size - 1) Color.Black else Color.Gray
                )
            }
        }
    }
}

@Composable
fun FlashcardView(
    frontText: String,
    backText: String,
    flipped: Boolean,
    onTap: () -> Unit
) {
    val rotation by animateFloatAsState(
        targetValue = if (flipped) 180f else 0f,
        animationSpec = tween(300)
    )

    val showBack = rotation > 90f
    val scaleX = if (showBack) -1f else 1f

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .clickable { onTap() }
            .graphicsLayer {
                rotationY = rotation
                this.scaleX = scaleX
                cameraDistance = 12 * density
            },
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 8.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (showBack) backText else frontText,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

