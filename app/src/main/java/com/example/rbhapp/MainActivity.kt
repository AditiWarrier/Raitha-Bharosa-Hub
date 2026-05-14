package com.example.rbhapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DashboardScreen()
        }
    }
}

@Composable
fun DashboardScreen(
    viewModel: RBHViewModel = viewModel()
) {

    val moisture = viewModel.moisture
    val sowingIndex = viewModel.sowingIndex
    val recommendation = viewModel.recommendation

    val isKannada =
        LanguageManager.isKannada.value

    val appTitle =
        if (isKannada)
            "ರೈತ ಭರೋಸಾ ಹಬ್"
        else
            "🌾 Raitha Bharosa Hub"

    val subtitle =
        if (isKannada)
            "ಸ್ಮಾರ್ಟ್ ಬಿತ್ತನೆ ಸಹಾಯಕ"
        else
            "Smart Sowing Assistant"

    val welcomeText =
        if (isKannada)
            "ಸ್ವಾಗತ ರೈತ 👋"
        else
            "Welcome Farmer 👋"

    val sowingText =
        if (isKannada)
            "ಬಿತ್ತನೆ ಸೂಚ್ಯಂಕ"
        else
            "Sowing Index"

    val moistureText =
        if (isKannada)
            "🌧 ಮಣ್ಣಿನ ತೇವಾಂಶ"
        else
            "🌧 Soil Moisture"

    val recommendationText =
        if (isKannada)
            "📢 ಶಿಫಾರಸು"
        else
            "📢 Recommendation"

    val buttonText =
        if (isKannada)
            "ವಿಶ್ಲೇಷಿಸಿ"
        else
            "Analyze Conditions"

    val languageButtonText =
        if (isKannada)
            "English"
        else
            "ಕನ್ನಡ"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFF1F8E9))
            .padding(20.dp)
    ) {

        Spacer(modifier = Modifier.height(12.dp))

        TopNavigationBar()

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                LanguageManager.isKannada.value =
                    !LanguageManager.isKannada.value

                viewModel.setLanguage(
                    LanguageManager.isKannada.value
                )
            },

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF33691E)
            ),

            shape = RoundedCornerShape(16.dp)
        ) {

            Text(
                text = languageButtonText
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = appTitle,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1B5E20)
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = subtitle,
            fontSize = 18.sp,
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = welcomeText,
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(30.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),

            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF4CAF50)
            ),

            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),

            shape = RoundedCornerShape(24.dp)
        ) {

            Column(
                modifier = Modifier.padding(28.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = sowingText,
                    fontSize = 20.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(14.dp))

                Text(
                    text = "$sowingIndex%",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),

            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),

            shape = RoundedCornerShape(24.dp)
        ) {

            Column(
                modifier = Modifier.padding(22.dp)
            ) {

                Text(
                    text = moistureText,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "$moisture%",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),

            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),

            shape = RoundedCornerShape(24.dp)
        ) {

            Column(
                modifier = Modifier.padding(22.dp)
            ) {

                Text(
                    text = recommendationText,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = recommendation,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {

                viewModel.setLanguage(
                    LanguageManager.isKannada.value
                )

                viewModel.generateData()
            },

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1B5E20)
            ),

            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp),

            shape = RoundedCornerShape(20.dp)
        ) {

            Text(
                text = buttonText,
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}