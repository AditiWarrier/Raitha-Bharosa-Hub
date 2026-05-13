package com.example.rbhapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class HistoryActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HistoryScreen()
        }
    }
}

@Composable
fun HistoryScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFF1F8E9))
            .padding(20.dp)
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        // Reusable Navigation

        TopNavigationBar()

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "📜 Farming History",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1B5E20)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Previous farming activity records",
            fontSize = 18.sp,
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(30.dp))

        HistoryCard(
            season = "Kharif 2025",
            crop = "Paddy",
            result = "✅ Good Yield",
            note = "Timely sowing improved crop growth."
        )

        HistoryCard(
            season = "Rabi 2024",
            crop = "Ragi",
            result = "⚠ Moderate Yield",
            note = "Low rainfall affected productivity."
        )

        HistoryCard(
            season = "Kharif 2024",
            crop = "Sugarcane",
            result = "✅ Healthy Crop",
            note = "Fertilizer timing was effective."
        )

        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
fun HistoryCard(
    season: String,
    crop: String,
    result: String,
    note: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 18.dp),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),

        shape = RoundedCornerShape(24.dp)
    ) {

        Column(
            modifier = Modifier.padding(22.dp)
        ) {

            Text(
                text = season,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1B5E20)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Crop: $crop",
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = result,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = note,
                fontSize = 17.sp,
                lineHeight = 25.sp
            )
        }
    }
}