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

    var currentCity: String = "Москва"

    private val cityForecasts: Map<String, List<WeatherDay>> = mapOf(
        "Москва" to listOf(
            WeatherDay("Понедельник", 22, "Солнечно", 40, 3.5, "С", 755, R.drawable.ic_sunny),
            WeatherDay("Вторник", 18, "Облачно", 65, 5.0, "СЗ", 750, R.drawable.ic_cloudy),
            WeatherDay("Среда", 15, "Дождь", 85, 7.2, "З", 745, R.drawable.ic_rainy),
            WeatherDay("Четверг", 12, "Гроза", 90, 10.0, "ЮЗ", 740, R.drawable.ic_storm),
            WeatherDay("Пятница", 20, "Переменная облачность", 55, 4.0, "Ю", 752, R.drawable.ic_partly_cloudy),
            WeatherDay("Суббота", 25, "Солнечно", 35, 2.0, "В", 758, R.drawable.ic_sunny),
            WeatherDay("Воскресенье", 23, "Малооблачно", 45, 3.0, "СВ", 756, R.drawable.ic_partly_cloudy)
        ),
        "Санкт-Петербург" to listOf(
            WeatherDay("Понедельник", 16, "Облачно", 75, 6.0, "СЗ", 748, R.drawable.ic_cloudy),
            WeatherDay("Вторник", 14, "Дождь", 88, 7.5, "З", 744, R.drawable.ic_rainy),
            WeatherDay("Среда", 13, "Дождь", 90, 8.0, "ЮЗ", 742, R.drawable.ic_rainy),
            WeatherDay("Четверг", 15, "Облачно", 70, 5.5, "С", 746, R.drawable.ic_cloudy),
            WeatherDay("Пятница", 17, "Переменная облачность", 60, 4.5, "СВ", 750, R.drawable.ic_partly_cloudy),
            WeatherDay("Суббота", 19, "Малооблачно", 50, 3.0, "В", 753, R.drawable.ic_partly_cloudy),
            WeatherDay("Воскресенье", 15, "Дождь", 82, 6.5, "ЮЗ", 747, R.drawable.ic_rainy)
        ),
        "Сочи" to listOf(
            WeatherDay("Понедельник", 28, "Солнечно", 55, 2.0, "Ю", 760, R.drawable.ic_sunny),
            WeatherDay("Вторник", 30, "Солнечно", 50, 1.5, "ЮВ", 762, R.drawable.ic_sunny),
            WeatherDay("Среда", 27, "Переменная облачность", 60, 3.0, "В", 758, R.drawable.ic_partly_cloudy),
            WeatherDay("Четверг", 25, "Гроза", 85, 8.0, "ЮЗ", 750, R.drawable.ic_storm),
            WeatherDay("Пятница", 26, "Облачно", 65, 4.0, "З", 754, R.drawable.ic_cloudy),
            WeatherDay("Суббота", 29, "Солнечно", 45, 2.5, "Ю", 761, R.drawable.ic_sunny),
            WeatherDay("Воскресенье", 31, "Солнечно", 40, 1.0, "ЮВ", 763, R.drawable.ic_sunny)
        ),
        "Новосибирск" to listOf(
            WeatherDay("Понедельник", 10, "Облачно", 70, 8.0, "СЗ", 745, R.drawable.ic_cloudy),
            WeatherDay("Вторник", 8, "Дождь", 80, 9.0, "С", 742, R.drawable.ic_rainy),
            WeatherDay("Среда", 5, "Дождь", 85, 10.5, "СЗ", 738, R.drawable.ic_rainy),
            WeatherDay("Четверг", 7, "Облачно", 75, 7.0, "З", 740, R.drawable.ic_cloudy),
            WeatherDay("Пятница", 12, "Переменная облачность", 60, 5.0, "ЮЗ", 748, R.drawable.ic_partly_cloudy),
            WeatherDay("Суббота", 15, "Малооблачно", 50, 4.0, "Ю", 752, R.drawable.ic_partly_cloudy),
            WeatherDay("Воскресенье", 11, "Облачно", 68, 6.5, "СВ", 746, R.drawable.ic_cloudy)
        ),
        "Казань" to listOf(
            WeatherDay("Понедельник", 19, "Солнечно", 45, 3.0, "Ю", 754, R.drawable.ic_sunny),
            WeatherDay("Вторник", 17, "Переменная облачность", 55, 4.5, "ЮЗ", 751, R.drawable.ic_partly_cloudy),
            WeatherDay("Среда", 14, "Дождь", 78, 6.0, "З", 747, R.drawable.ic_rainy),
            WeatherDay("Четверг", 16, "Облачно", 65, 5.0, "СЗ", 749, R.drawable.ic_cloudy),
            WeatherDay("Пятница", 20, "Солнечно", 40, 2.5, "В", 756, R.drawable.ic_sunny),
            WeatherDay("Суббота", 22, "Солнечно", 38, 2.0, "ЮВ", 758, R.drawable.ic_sunny),
            WeatherDay("Воскресенье", 18, "Малооблачно", 50, 3.5, "С", 753, R.drawable.ic_partly_cloudy)
        )
    )

    val availableCities: Array<String>
        get() = cityForecasts.keys.toTypedArray()

    val forecast: List<WeatherDay>
        get() = cityForecasts[currentCity] ?: cityForecasts["Москва"]!!
}