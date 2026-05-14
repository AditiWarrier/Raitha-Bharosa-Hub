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

    val weatherList =
        MockWeatherRepository.getWeatherData()

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

        weatherList.forEach { weather ->

            CalendarCard(

                day =
                    if (isKannada)
                        weather.dayKannada
                    else
                        weather.dayEnglish,

                weather =
                    if (isKannada)
                        weather.weatherKannada
                    else
                        weather.weatherEnglish,

                action =
                    if (isKannada)
                        weather.actionKannada
                    else
                        weather.actionEnglish
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
                fontSize = 16.sp,
                lineHeight = 24.sp
            )
        }
    }
}