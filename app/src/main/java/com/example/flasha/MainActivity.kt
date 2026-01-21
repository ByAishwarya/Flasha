package com.example.flasha

import AddFlashcardScreen
import ChooseCategoryScreen
import ChooseLevelScreen
import FlashcardListScreen
import FlashcardViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flasha.ui.theme.FlashaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlashaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

// Define LandingScreen before it's called in AppNavigation
@Composable
fun LandingScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Flasha!",
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Master German vocabulary with interactive flashcards",
            color = Color.Black,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Learn at your own pace",
            color = Color.Black,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "A1 to B2 level content",
            color = Color.Black,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
        Button(
            onClick = { navController.navigate("choose_level") },
            modifier = Modifier.padding(top = 24.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Get Started",
                fontSize = 18.sp
            )
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val flashcardViewModel: FlashcardViewModel = viewModel()
    NavHost(navController = navController, startDestination = "landing") {
        composable("landing") {
            // Now this call is valid
            LandingScreen(navController = navController)
        }
        composable("choose_level") {
            ChooseLevelScreen(navController = navController, vm=flashcardViewModel)
        }
        composable("choose_category") {
            ChooseCategoryScreen(navController = navController, vm=flashcardViewModel)
        }
        composable("flashcards") {
            FlashcardsScreen(navController = navController, vm=flashcardViewModel)
        }
        composable("list") {
            FlashcardListScreen(
                navController = navController,
                vm=flashcardViewModel
            )
        }

        composable("add") {
            AddFlashcardScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
