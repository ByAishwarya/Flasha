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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flasha.utils.FlashcardViewModel

// Gradient colors from Figma
val GermanGradientStart = Color(0xFF3B82F6)  // Blue
val GermanGradientEnd = Color(0xFF9333EA)    // Purple

val EnglishGradientStart = Color(0xFF9333EA) // Purple
val EnglishGradientEnd = Color(0xFFEC4899)   // Pink

@Composable
fun FlashcardsScreen(
    navController: NavController,
    vm: FlashcardViewModel
) {
    val uiState by vm.uiState.collectAsState()
    val flashcards = uiState.flashcards

    var currentIndex by remember { mutableIntStateOf(0) }
    var flipped by remember { mutableStateOf(false) }

    // Handle empty flashcards case
    if (flashcards.isEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "No flashcards available for this selection",
                fontSize = 18.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(16.dp))
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }
        }
        return
    }

    val currentCard = flashcards[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
    ) {
        // TOP BAR — Card counter and back button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }

            Text(
                text = "Card ${currentIndex + 1} of ${flashcards.size}",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.width(48.dp))
        }

        Spacer(modifier = Modifier.height(40.dp))

        // CENTERED CARD
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            FlashcardView(
                frontText = currentCard.german,
                backText = currentCard.english,
                flipped = flipped,
                onTap = { flipped = !flipped }
            )
        }

        // Progress dots
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            for (i in flashcards.indices) {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .size(width = if (i == currentIndex) 24.dp else 8.dp, height = 8.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(
                            if (i == currentIndex) Color(0xFF7C3AED) else Color.LightGray
                        )
                )
            }
        }

        // NAV BUTTONS
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Previous Button
            OutlinedButton(
                onClick = {
                    flipped = false
                    currentIndex--
                },
                enabled = currentIndex > 0,
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Previous",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Previous",
                    fontSize = 16.sp
                )
            }

            // Next Button
            Button(
                onClick = {
                    flipped = false
                    currentIndex++
                },
                enabled = currentIndex < flashcards.size - 1,
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                )
            ) {
                Text(
                    text = "Next",
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Next",
                    modifier = Modifier.size(20.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
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
        animationSpec = tween(400),
        label = "rotation"
    )

    val showBack = rotation > 90f
    val scaleX = if (showBack) -1f else 1f

    // Choose gradient based on which side is showing
    val gradient = if (showBack) {
        // English side - Purple to Pink
        Brush.linearGradient(
            colors = listOf(EnglishGradientStart, EnglishGradientEnd)
        )
    } else {
        // German side - Blue to Purple
        Brush.linearGradient(
            colors = listOf(GermanGradientStart, GermanGradientEnd)
        )
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .height(320.dp)
            .clickable { onTap() }
            .graphicsLayer {
                rotationY = rotation
                this.scaleX = scaleX
                cameraDistance = 12 * density
            },
        shape = RoundedCornerShape(24.dp),
        shadowElevation = 8.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradient),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Language label - 12sp, normal weight, 70% opacity
                Text(
                    text = if (showBack) "ENGLISH" else "GERMAN",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White.copy(alpha = 0.7f),
                    letterSpacing = 2.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Word - 30sp, normal weight, with proper line height
                Text(
                    text = if (showBack) backText else frontText,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    lineHeight = 40.sp,  // Added line height to prevent touching
                    modifier = Modifier.padding(horizontal = 24.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Tap to flip hint - 12sp, normal weight, 70% opacity
                Text(
                    text = "Tap to flip",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White.copy(alpha = 0.7f)
                )
            }
        }
    }
}