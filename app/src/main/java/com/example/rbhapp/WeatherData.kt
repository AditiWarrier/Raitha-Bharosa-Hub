package com.example.rbhapp

data class WeatherData(

    val dayEnglish: String,

    val dayKannada: String,

    val weatherEnglish: String,

    val weatherKannada: String,

    val actionEnglish: String,

    val actionKannada: String
)

object MockWeatherRepository {

    fun getWeatherData():
            List<WeatherData> {

        return listOf(

            WeatherData(

                dayEnglish = "Monday",

                dayKannada = "ಸೋಮವಾರ",

                weatherEnglish = "☀ Sunny",

                weatherKannada = "☀ ಬಿಸಿಲು",

                actionEnglish =
                    "✅ Good day for sowing Paddy",

                actionKannada =
                    "✅ ನೆಲ ಬಿತ್ತನೆಗೆ ಉತ್ತಮ ದಿನ"
            ),

            WeatherData(

                dayEnglish = "Tuesday",

                dayKannada = "ಮಂಗಳವಾರ",

                weatherEnglish = "🌧 Heavy Rain",

                weatherKannada = "🌧 ಭಾರಿ ಮಳೆ",

                actionEnglish =
                    "⚠ Avoid fertilizer application",

                actionKannada =
                    "⚠ ರಸಗೊಬ್ಬರ ಬಳಕೆ ತಪ್ಪಿಸಿ"
            ),

            WeatherData(

                dayEnglish = "Wednesday",

                dayKannada = "ಬುಧವಾರ",

                weatherEnglish = "⛅ Cloudy",

                weatherKannada = "⛅ ಮೋಡ",

                actionEnglish =
                    "✅ Soil conditions are stable",

                actionKannada =
                    "✅ ಮಣ್ಣಿನ ಪರಿಸ್ಥಿತಿ ಸ್ಥಿರವಾಗಿದೆ"
            ),

            WeatherData(

                dayEnglish = "Thursday",

                dayKannada = "ಗುರುವಾರ",

                weatherEnglish = "🌦 Light Rain",

                weatherKannada = "🌦 ತುಂತುರು ಮಳೆ",

                actionEnglish =
                    "⚠ Delay pesticide spraying",

                actionKannada =
                    "⚠ ಕೀಟನಾಶಕ ಸಿಂಪಡಣೆ ವಿಳಂಬಿಸಿ"
            ),

            WeatherData(

                dayEnglish = "Friday",

                dayKannada = "ಶುಕ್ರವಾರ",

                weatherEnglish = "☀ Sunny",

                weatherKannada = "☀ ಬಿಸಿಲು",

                actionEnglish =
                    "✅ Best day for irrigation",

                actionKannada =
                    "✅ ನೀರಾವರಿಗೆ ಉತ್ತಮ ದಿನ"
            ),

            WeatherData(

                dayEnglish = "Saturday",

                dayKannada = "ಶನಿವಾರ",

                weatherEnglish = "🌧 Storm Warning",

                weatherKannada =
                    "🌧 ಗಾಳಿ ಮಳೆ ಎಚ್ಚರಿಕೆ",

                actionEnglish =
                    "❌ Avoid sowing activities",

                actionKannada =
                    "❌ ಬಿತ್ತನೆ ಚಟುವಟಿಕೆ ತಪ್ಪಿಸಿ"
            ),

            WeatherData(

                dayEnglish = "Sunday",

                dayKannada = "ಭಾನುವಾರ",

                weatherEnglish =
                    "⛅ Mild Weather",

                weatherKannada =
                    "⛅ ಸಮಶೀತೋಷ್ಣ ಹವಾಮಾನ",

                actionEnglish =
                    "✅ Good conditions for fertilization",

                actionKannada =
                    "✅ ಗೊಬ್ಬರ ಬಳಕೆಗಾಗಿ ಉತ್ತಮ ಪರಿಸ್ಥಿತಿ"
            )
        )
    }
}