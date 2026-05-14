package com.example.rbhapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class RBHViewModel : ViewModel() {

    var moisture by mutableIntStateOf(0)
        private set

    var sowingIndex by mutableIntStateOf(0)
        private set

    var recommendation by mutableStateOf("")
        private set

    var isKannada by mutableStateOf(false)

    init {
        generateData()
    }

    fun setLanguage(
        kannada: Boolean
    ) {

        isKannada = kannada

        generateData()
    }

    fun generateData() {

        moisture = DataGenerator.generateMoisture()

        sowingIndex = when {

            moisture > 30 -> 35

            moisture in 20..30 -> 85

            else -> 60
        }

        recommendation = when {

            moisture > 30 ->

                if (isKannada)
                    "❌ ಮಣ್ಣು ಬಿತ್ತನೆಗೆ ತುಂಬಾ ತೇವವಾಗಿದೆ"
                else
                    "❌ Soil too wet to sow"

            moisture in 20..30 ->

                if (isKannada)
                    "✅ ಬಿತ್ತನೆಗೆ ಅತ್ಯುತ್ತಮ ಪರಿಸ್ಥಿತಿ"
                else
                    "✅ Ideal conditions for sowing"

            else ->

                if (isKannada)
                    "⚠️ ಮಣ್ಣಿನ ತೇವಾಂಶ ಕಡಿಮೆಯಾಗಿದೆ"
                else
                    "⚠️ Soil moisture is low"
        }
    }
}