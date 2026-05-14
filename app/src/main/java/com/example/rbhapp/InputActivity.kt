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
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InputActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            InputScreen()
        }
    }
}

@Composable
fun InputScreen() {

    var moisture by remember {
        mutableStateOf("")
    }

    var nitrogen by remember {
        mutableStateOf("")
    }

    var phosphorus by remember {
        mutableStateOf("")
    }

    var potassium by remember {
        mutableStateOf("")
    }

    var result by remember {
        mutableStateOf("")
    }

    var sowingIndex by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    val database =
        AppDatabase.getDatabase(context)

    val historyDao =
        database.historyDao()

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
            text = "🌾 Input Center",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1B5E20)
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Enter soil and nutrient details",
            fontSize = 18.sp,
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(30.dp))

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

                OutlinedTextField(
                    value = moisture,

                    onValueChange = {
                        moisture = it
                    },

                    label = {
                        Text("Soil Moisture (%)")
                    },

                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(16.dp)
                )

                Spacer(modifier = Modifier.height(18.dp))

                OutlinedTextField(
                    value = nitrogen,

                    onValueChange = {
                        nitrogen = it
                    },

                    label = {
                        Text("Nitrogen (N)")
                    },

                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(16.dp)
                )

                Spacer(modifier = Modifier.height(18.dp))

                OutlinedTextField(
                    value = phosphorus,

                    onValueChange = {
                        phosphorus = it
                    },

                    label = {
                        Text("Phosphorus (P)")
                    },

                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(16.dp)
                )

                Spacer(modifier = Modifier.height(18.dp))

                OutlinedTextField(
                    value = potassium,

                    onValueChange = {
                        potassium = it
                    },

                    label = {
                        Text("Potassium (K)")
                    },

                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(16.dp)
                )

                Spacer(modifier = Modifier.height(28.dp))

                Button(
                    onClick = {

                        if (moisture.toIntOrNull() == null) {

                            result =
                                "Please enter valid soil moisture"

                            sowingIndex = "--"

                        } else {

                            val moistureValue =
                                moisture.toInt()

                            when {

                                moistureValue > 30 -> {

                                    sowingIndex = "35%"

                                    result =
                                        "❌ Soil is too wet for sowing.\n\nRecommendation:\nDelay sowing for 1-2 days and avoid fertilizer application."
                                }

                                moistureValue in 20..30 -> {

                                    sowingIndex = "85%"

                                    result =
                                        "✅ Excellent conditions for sowing.\n\nRecommendation:\nProceed with sowing within the next 48 hours."
                                }

                                else -> {

                                    sowingIndex = "55%"

                                    result =
                                        "⚠ Soil moisture is low.\n\nRecommendation:\nIrrigate field before sowing crops."
                                }
                            }

                            CoroutineScope(Dispatchers.IO).launch {

                                historyDao.insertHistory(

                                    HistoryEntity(

                                        moisture = moisture,

                                        nitrogen = nitrogen,

                                        phosphorus = phosphorus,

                                        potassium = potassium,

                                        sowingIndex = sowingIndex,

                                        recommendation = result,

                                        timestamp =
                                            System.currentTimeMillis()
                                    )
                                )
                            }
                        }
                    },

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1B5E20)
                    ),

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),

                    shape = RoundedCornerShape(18.dp)
                ) {

                    Text(
                        text = "Analyze Soil",
                        fontSize = 18.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),

            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),

            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),

            shape = RoundedCornerShape(24.dp)
        ) {

            Column(
                modifier = Modifier.padding(24.dp)
            ) {

                Text(
                    text = "📊 Analysis Result",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1B5E20)
                )

                Spacer(modifier = Modifier.height(18.dp))

                Text(
                    text = "Sowing Index: $sowingIndex",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(18.dp))

                Text(
                    text = result,
                    fontSize = 18.sp,
                    lineHeight = 28.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}