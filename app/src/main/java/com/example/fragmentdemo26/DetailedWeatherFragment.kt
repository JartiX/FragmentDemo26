package com.example.fragmentdemo26

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailedWeatherFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detailed_weather, container, false)

        val containerLayout = view.findViewById<LinearLayout>(R.id.detailedContainer)

        for (day in WeatherData.forecast) {
            val itemView = inflater.inflate(R.layout.item_detailed_weather, containerLayout, false)

            val ivIcon = itemView.findViewById<ImageView>(R.id.ivDetailIcon)
            val tvDay = itemView.findViewById<TextView>(R.id.tvDetailDay)
            val tvTemp = itemView.findViewById<TextView>(R.id.tvDetailTemp)
            val tvDesc = itemView.findViewById<TextView>(R.id.tvDetailDesc)
            val tvHumidity = itemView.findViewById<TextView>(R.id.tvDetailHumidity)
            val tvWind = itemView.findViewById<TextView>(R.id.tvDetailWind)
            val tvPressure = itemView.findViewById<TextView>(R.id.tvDetailPressure)

            ivIcon.setImageResource(day.iconResId)
            tvDay.text = day.dayOfWeek
            tvTemp.text = "Температура: ${day.temperature}°C"
            tvDesc.text = "Описание: ${day.description}"
            tvHumidity.text = "Влажность: ${day.humidity}%"
            tvWind.text = "Ветер: ${day.windSpeed} м/с, ${day.windDirection}"
            tvPressure.text = "Давление: ${day.pressure} мм рт.ст."

            containerLayout.addView(itemView)
        }

        return view
    }
}