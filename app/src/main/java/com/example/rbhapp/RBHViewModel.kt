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

    init {
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
                "❌ Soil too wet to sow"

            moisture in 20..30 ->
                "✅ Ideal conditions for sowing"

            else ->
                "⚠️ Soil moisture is low"
        }
    }
}