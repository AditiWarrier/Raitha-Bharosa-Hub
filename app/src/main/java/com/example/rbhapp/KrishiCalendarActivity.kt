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
import androidx.compose.runtime.getValue
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

    val isKannada =
        LanguageManager.isKannada.value

    val title =
        if (isKannada)
            "🌾 ಕೃಷಿ ಕ್ಯಾಲೆಂಡರ್"
        else
            "🌾 Krishi Calendar"

    val subtitle =
        if (isKannada)
            "7 ದಿನಗಳ ಸ್ಮಾರ್ಟ್ ಕೃಷಿ ಯೋಜನೆ"
        else
            "7-Day Smart Farming Plan"

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
            text = title,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1B5E20)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = subtitle,
            fontSize = 18.sp,
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(30.dp))

        if (isKannada) {

            CalendarCard(
                day = "ಸೋಮವಾರ",
                weather = "☀ ಬಿಸಿಲು",
                action = "✅ ನೆಲ ಬಿತ್ತನೆಗೆ ಉತ್ತಮ ದಿನ"
            )

            CalendarCard(
                day = "ಮಂಗಳವಾರ",
                weather = "🌧 ಭಾರಿ ಮಳೆ",
                action = "⚠ ರಸಗೊಬ್ಬರ ಬಳಕೆ ತಪ್ಪಿಸಿ"
            )

            CalendarCard(
                day = "ಬುಧವಾರ",
                weather = "⛅ ಮೋಡ"
                ,
                action = "✅ ಮಣ್ಣಿನ ಪರಿಸ್ಥಿತಿ ಸ್ಥಿರವಾಗಿದೆ"
            )

            CalendarCard(
                day = "ಗುರುವಾರ",
                weather = "🌦 ತುಂತುರು ಮಳೆ",
                action = "⚠ ಕೀಟನಾಶಕ ಸಿಂಪಡಣೆ ವಿಳಂಬಿಸಿ"
            )

            CalendarCard(
                day = "ಶುಕ್ರವಾರ",
                weather = "☀ ಬಿಸಿಲು",
                action = "✅ ನೀರಾವರಿಗೆ ಉತ್ತಮ ದಿನ"
            )

            CalendarCard(
                day = "ಶನಿವಾರ",
                weather = "🌧 ಗಾಳಿ ಮಳೆ ಎಚ್ಚರಿಕೆ",
                action = "❌ ಬಿತ್ತನೆ ಚಟುವಟಿಕೆ ತಪ್ಪಿಸಿ"
            )

            CalendarCard(
                day = "ಭಾನುವಾರ",
                weather = "⛅ ಸಮಶೀತೋಷ್ಣ ಹವಾಮಾನ",
                action = "✅ ಗೊಬ್ಬರ ಬಳಕೆಗಾಗಿ ಉತ್ತಮ ಪರಿಸ್ಥಿತಿ"
            )

        } else {

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
        }

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