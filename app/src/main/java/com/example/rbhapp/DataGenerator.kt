package com.example.rbhapp

data class SoilAnalysisResult(

    val sowingIndex: String,

    val recommendation: String
)

object DataGenerator {

    fun generateMoisture(): Int {

        return (10..40).random()
    }

    fun analyzeSoil(
        moisture: Int,
        isKannada: Boolean
    ): SoilAnalysisResult {

        return when {

            moisture > 30 -> {

                SoilAnalysisResult(

                    sowingIndex = "35%",

                    recommendation =

                        if (isKannada)

                            "❌ ಮಣ್ಣು ಬಿತ್ತನೆಗೆ ತುಂಬಾ ತೇವವಾಗಿದೆ.\n\nಶಿಫಾರಸು:\n1-2 ದಿನ ಬಿತ್ತನೆ ವಿಳಂಬ ಮಾಡಿ ಮತ್ತು ರಸಗೊಬ್ಬರ ಬಳಕೆ ತಪ್ಪಿಸಿ."

                        else

                            "❌ Soil is too wet for sowing.\n\nRecommendation:\nDelay sowing for 1-2 days and avoid fertilizer application."
                )
            }

            moisture in 20..30 -> {

                SoilAnalysisResult(

                    sowingIndex = "85%",

                    recommendation =

                        if (isKannada)

                            "✅ ಬಿತ್ತನೆಗೆ ಅತ್ಯುತ್ತಮ ಪರಿಸ್ಥಿತಿ.\n\nಶಿಫಾರಸು:\nಮುಂದಿನ 48 ಗಂಟೆಗಳ ಒಳಗೆ ಬಿತ್ತನೆ ಪ್ರಾರಂಭಿಸಿ."

                        else

                            "✅ Excellent conditions for sowing.\n\nRecommendation:\nProceed with sowing within the next 48 hours."
                )
            }

            else -> {

                SoilAnalysisResult(

                    sowingIndex = "55%",

                    recommendation =

                        if (isKannada)

                            "⚠ ಮಣ್ಣಿನ ತೇವಾಂಶ ಕಡಿಮೆಯಾಗಿದೆ.\n\nಶಿಫಾರಸು:\nಬಿತ್ತನೆ ಮೊದಲು ನೀರಾವರಿ ಮಾಡಿ."

                        else

                            "⚠ Soil moisture is low.\n\nRecommendation:\nIrrigate field before sowing crops."
                )
            }
        }
    }
}