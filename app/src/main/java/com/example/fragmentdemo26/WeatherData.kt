package com.example.fragmentdemo26

data class WeatherDay(
    val dayOfWeek: String,
    val temperature: Int,
    val description: String,
    val humidity: Int,
    val windSpeed: Double,
    val windDirection: String,
    val pressure: Int,
    val iconResId: Int
)

object WeatherData {
    val forecast: List<WeatherDay> = listOf(
        WeatherDay(
            dayOfWeek = "Понедельник",
            temperature = 22,
            description = "Солнечно",
            humidity = 40,
            windSpeed = 3.5,
            windDirection = "С",
            pressure = 755,
            iconResId = R.drawable.ic_sunny
        ),
        WeatherDay(
            dayOfWeek = "Вторник",
            temperature = 18,
            description = "Облачно",
            humidity = 65,
            windSpeed = 5.0,
            windDirection = "СЗ",
            pressure = 750,
            iconResId = R.drawable.ic_cloudy
        ),
        WeatherDay(
            dayOfWeek = "Среда",
            temperature = 15,
            description = "Дождь",
            humidity = 85,
            windSpeed = 7.2,
            windDirection = "З",
            pressure = 745,
            iconResId = R.drawable.ic_rainy
        ),
        WeatherDay(
            dayOfWeek = "Четверг",
            temperature = 12,
            description = "Гроза",
            humidity = 90,
            windSpeed = 10.0,
            windDirection = "ЮЗ",
            pressure = 740,
            iconResId = R.drawable.ic_storm
        ),
        WeatherDay(
            dayOfWeek = "Пятница",
            temperature = 20,
            description = "Переменная облачность",
            humidity = 55,
            windSpeed = 4.0,
            windDirection = "Ю",
            pressure = 752,
            iconResId = R.drawable.ic_partly_cloudy
        ),
        WeatherDay(
            dayOfWeek = "Суббота",
            temperature = 25,
            description = "Солнечно",
            humidity = 35,
            windSpeed = 2.0,
            windDirection = "В",
            pressure = 758,
            iconResId = R.drawable.ic_sunny
        ),
        WeatherDay(
            dayOfWeek = "Воскресенье",
            temperature = 23,
            description = "Малооблачно",
            humidity = 45,
            windSpeed = 3.0,
            windDirection = "СВ",
            pressure = 756,
            iconResId = R.drawable.ic_partly_cloudy
        )
    )
}