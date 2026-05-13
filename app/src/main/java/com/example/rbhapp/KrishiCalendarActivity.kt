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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class KrishiCalendarActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            KrishiCalendarScreen()
        }
    }
}

@Composable
fun KrishiCalendarScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFF1F8E9))
            .padding(20.dp)
    ) {

        Spacer(modifier = Modifier.height(16.dp))
        TopNavigationBar()

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "🌾 Krishi Calendar",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1B5E20)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "7-Day Smart Farming Plan",
            fontSize = 18.sp,
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(30.dp))

        CalendarCard(
            day = "Monday",
            weather = "☀ Sunny",
            action = "✅ Good day for sowing Paddy"
        )

        CalendarCard(
            day = "Tuesday",
            weather = "🌧 Heavy Rain",
            action = "⚠ Avoid fertilizer application"
        )

        CalendarCard(
            day = "Wednesday",
            weather = "⛅ Cloudy",
            action = "✅ Soil conditions are stable"
        )

        CalendarCard(
            day = "Thursday",
            weather = "🌦 Light Rain",
            action = "⚠ Delay pesticide spraying"
        )

        CalendarCard(
            day = "Friday",
            weather = "☀ Sunny",
            action = "✅ Best day for irrigation"
        )

        CalendarCard(
            day = "Saturday",
            weather = "🌧 Storm Warning",
            action = "❌ Avoid sowing activities"
        )

        CalendarCard(
            day = "Sunday",
            weather = "⛅ Mild Weather",
            action = "✅ Good conditions for fertilization"
        )

        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
fun CalendarCard(
    day: String,
    weather: String,
    action: String
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
                text = day,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1B5E20)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = weather,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = action,
                fontSize = 18.sp,
                lineHeight = 26.sp
            )
        }
    }
}