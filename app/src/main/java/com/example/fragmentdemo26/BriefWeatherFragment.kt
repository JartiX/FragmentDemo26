package com.example.fragmentdemo26

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class BriefWeatherFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_brief_weather, container, false)

        val containerLayout = view.findViewById<LinearLayout>(R.id.briefContainer)

        for (day in WeatherData.forecast) {
            val itemView = inflater.inflate(R.layout.item_brief_weather, containerLayout, false)

            val tvDay = itemView.findViewById<TextView>(R.id.tvBriefDay)
            val ivIcon = itemView.findViewById<ImageView>(R.id.ivWeatherIcon)
            val tvTemp = itemView.findViewById<TextView>(R.id.tvBriefTemp)

            tvDay.text = day.dayOfWeek.take(3) 
            ivIcon.setImageResource(day.iconResId)
            tvTemp.text = "${day.temperature}°C"

            containerLayout.addView(itemView)
        }

        return view
    }
}