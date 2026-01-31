package com.example.flasha

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

// LinkedIn profile URLs
private const val LINKEDIN_AISHWARYA = "https://www.linkedin.com/in/byaishwarya/"
private const val LINKEDIN_MAHDI = "https://www.linkedin.com/in/mahdi-aghaali"
private const val LINKEDIN_AYA = "https://www.linkedin.com/in/ayalaomarova22/"

// Team member data class
data class TeamMember(
    val name: String,
    val role: String,
    val linkedInUrl: String,
    val cardColor: Color
)

@Composable
fun ContactSupportScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    val teamMembers = listOf(
        TeamMember(
            name = "Aishwarya",
            role = "Product Manager",
            linkedInUrl = LINKEDIN_AISHWARYA,
            cardColor = Color(0xFFE53935) // Red
        ),
        TeamMember(
            name = "Mahdi",
            role = "Frontend Developer",
            linkedInUrl = LINKEDIN_MAHDI,
            cardColor = Color(0xFFFF7043) // Orange
        ),
        TeamMember(
            name = "Aya",
            role = "Backend Developer",
            linkedInUrl = LINKEDIN_AYA,
            cardColor = Color(0xFFFFB74D) // Light Orange/Yellow
        )
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF1A1A2E), // Dark blue/black at top
                        Color(0xFF6B2D2D), // Dark red
                        Color(0xFFE53935), // Red
                        Color(0xFFFF9800), // Orange
                        Color(0xFFFFD54F)  // Yellow at bottom
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top bar with back button and title
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
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
                    text = "Contact Support",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Help icon in circle
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.White.copy(alpha = 0.3f), CircleShape)
                    .background(Color.White.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Help,
                    contentDescription = "Help",
                    tint = Color.White.copy(alpha = 0.8f),
                    modifier = Modifier.size(40.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // "Need Help?" text
            Text(
                text = "Need Help?",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Subtitle
            Text(
                text = "Our team is here to assist you. Reach out\nto us on LinkedIn!",
                color = Color.White.copy(alpha = 0.9f),
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Team member cards
            teamMembers.forEach { member ->
                TeamMemberCard(
                    member = member,
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(member.linkedInUrl))
                        context.startActivity(intent)
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            Spacer(modifier = Modifier.weight(1f))

            // Response time text at bottom
            Text(
                text = "We typically respond within 24 hours",
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 24.dp)
            )
        }
    }
}

@Composable
fun TeamMemberCard(
    member: TeamMember,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(member.cardColor.copy(alpha = 0.7f))
            .border(
                width = 1.dp,
                color = Color.White.copy(alpha = 0.3f),
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = member.name,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = member.role,
                    color = Color.White.copy(alpha = 0.9f),
                    fontSize = 14.sp
                )
            }

            // LinkedIn icon button
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(getLinkedInColor(member.cardColor)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "in",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

// Returns different LinkedIn button colors based on card color
@Composable
fun getLinkedInColor(cardColor: Color): Color {
    return when {
        cardColor == Color(0xFFE53935) -> Color(0xFF0077B5) // Blue for red card
        cardColor == Color(0xFFFF7043) -> Color(0xFF7B1FA2) // Purple for orange card
        else -> Color(0xFFE91E63) // Pink for yellow card
    }
}