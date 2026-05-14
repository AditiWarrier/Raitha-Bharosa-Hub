package com.example.rbhapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*

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

    val isKannada =
        LanguageManager.isKannada.value

    val title =
        if (isKannada)
            "📜 ಕೃಷಿ ಇತಿಹಾಸ"
        else
            "📜 Farming History"

    val subtitle =
        if (isKannada)
            "ಉಳಿಸಿದ ಮಣ್ಣಿನ ವಿಶ್ಲೇಷಣೆ ದಾಖಲೆಗಳು"
        else
            "Saved soil analysis records"

    val context = LocalContext.current

    val database =
        AppDatabase.getDatabase(context)

    val historyDao =
        database.historyDao()

    var historyList by remember {
        mutableStateOf<List<HistoryEntity>>(
            emptyList()
        )
    }

    LaunchedEffect(Unit) {

        withContext(Dispatchers.IO) {

            historyList =
                historyDao.getAllHistory()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
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

        LazyColumn {

            items(historyList) { history ->

                HistoryCard(
                    history,
                    isKannada
                )
            }
        }
    }
}

@Composable
fun HistoryCard(
    history: HistoryEntity,
    isKannada: Boolean
) {

    val formattedDate = SimpleDateFormat(
        "dd MMM yyyy, hh:mm a",
        Locale.getDefault()
    ).format(Date(history.timestamp))

    val moistureText =
        if (isKannada)
            "ತೇವಾಂಶ"
        else
            "Moisture"

    val sowingText =
        if (isKannada)
            "ಬಿತ್ತನೆ ಸೂಚ್ಯಂಕ"
        else
            "Sowing Index"

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
                text = formattedDate,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1B5E20)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "$moistureText: ${history.moisture}%",
                fontSize = 17.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "NPK: ${history.nitrogen} / ${history.phosphorus} / ${history.potassium}",
                fontSize = 17.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "$sowingText: ${history.sowingIndex}",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = history.recommendation,
                fontSize = 17.sp,
                lineHeight = 25.sp
            )
        }
    }
}