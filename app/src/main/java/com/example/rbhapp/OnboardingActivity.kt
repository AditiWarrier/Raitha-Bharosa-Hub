package com.example.rbhapp

import android.content.Intent
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class OnboardingActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            OnboardingScreen(this)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingScreen(
    activity: ComponentActivity
) {

    val isKannada =
        LanguageManager.isKannada.value

    var farmerName by remember {
        mutableStateOf("")
    }

    var region by remember {
        mutableStateOf("")
    }

    var expanded by remember {
        mutableStateOf(false)
    }

    var selectedCrop by remember {
        mutableStateOf("")
    }

    val cropList = listOf(
        "Paddy",
        "Ragi",
        "Sugarcane",
        "Wheat",
        "Cotton"
    )

    val title =
        if (isKannada)
            "🌾 ರೈತ ಪರಿಚಯ"
        else
            "🌾 Farmer Onboarding"

    val subtitle =
        if (isKannada)
            "ರೈತರ ವಿವರಗಳನ್ನು ನಮೂದಿಸಿ"
        else
            "Enter farmer details"

    val nameLabel =
        if (isKannada)
            "ರೈತನ ಹೆಸರು"
        else
            "Farmer Name"

    val regionLabel =
        if (isKannada)
            "ಪ್ರದೇಶ"
        else
            "Region"

    val cropLabel =
        if (isKannada)
            "ಬೆಳೆ ಆಯ್ಕೆಮಾಡಿ"
        else
            "Select Crop"

    val buttonText =
        if (isKannada)
            "ಮುಂದುವರಿಸಿ"
        else
            "Continue"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFF1F8E9))
            .padding(20.dp)
    ) {

        Spacer(modifier = Modifier.height(40.dp))

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

        Spacer(modifier = Modifier.height(40.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(24.dp),

            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            )
        ) {

            Column(
                modifier = Modifier.padding(24.dp)
            ) {

                OutlinedTextField(
                    value = farmerName,

                    onValueChange = {
                        farmerName = it
                    },

                    label = {
                        Text(nameLabel)
                    },

                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(16.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                OutlinedTextField(
                    value = region,

                    onValueChange = {
                        region = it
                    },

                    label = {
                        Text(regionLabel)
                    },

                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(16.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                ExposedDropdownMenuBox(
                    expanded = expanded,

                    onExpandedChange = {
                        expanded = !expanded
                    }
                ) {

                    OutlinedTextField(
                        value = selectedCrop,

                        onValueChange = {},

                        readOnly = true,

                        label = {
                            Text(cropLabel)
                        },

                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(
                                expanded = expanded
                            )
                        },

                        modifier = Modifier
                            .menuAnchor()
                            .fillMaxWidth(),

                        shape = RoundedCornerShape(16.dp)
                    )

                    ExposedDropdownMenu(
                        expanded = expanded,

                        onDismissRequest = {
                            expanded = false
                        }
                    ) {

                        cropList.forEach { crop ->

                            DropdownMenuItem(

                                text = {
                                    Text(crop)
                                },

                                onClick = {

                                    selectedCrop = crop

                                    expanded = false
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = {

                        val intent =
                            Intent(
                                activity,
                                MainActivity::class.java
                            )

                        activity.startActivity(intent)

                        activity.finish()
                    },

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),

                    shape = RoundedCornerShape(18.dp),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1B5E20)
                    )
                ) {

                    Text(
                        text = buttonText,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}