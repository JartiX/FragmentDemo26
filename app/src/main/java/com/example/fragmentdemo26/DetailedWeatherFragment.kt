package com.example.fragmentdemo26

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class DetailedWeatherFragment : Fragment() {

    companion object {
        private const val ARG_DESIGN = "design_index"

        fun newInstance(designIndex: Int): DetailedWeatherFragment {
            val fragment = DetailedWeatherFragment()
            val args = Bundle()
            args.putInt(ARG_DESIGN, designIndex)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detailed_weather, container, false)
        val containerLayout = view.findViewById<LinearLayout>(R.id.detailedContainer)
        val designIndex = arguments?.getInt(ARG_DESIGN, 0) ?: 0

        when (designIndex) {
            0 -> view.setBackgroundColor(Color.parseColor("#FFF3E0"))
            1 -> view.setBackgroundColor(Color.parseColor("#1B1B2F"))
            2 -> view.setBackgroundColor(Color.parseColor("#FFF9C4"))
        }

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

            when (designIndex) {
                1 -> {
                    val card = itemView as? CardView
                    card?.setCardBackgroundColor(Color.parseColor("#2C2C54"))
                    tvDay.setTextColor(Color.WHITE)
                    tvTemp.setTextColor(Color.parseColor("#FF7043"))
                    tvDesc.setTextColor(Color.parseColor("#B0BEC5"))
                    tvHumidity.setTextColor(Color.parseColor("#90A4AE"))
                    tvWind.setTextColor(Color.parseColor("#90A4AE"))
                    tvPressure.setTextColor(Color.parseColor("#90A4AE"))
                }
                2 -> {
                    val card = itemView as? CardView
                    card?.setCardBackgroundColor(Color.parseColor("#FFF9C4"))
                    tvDay.setTextColor(Color.parseColor("#4A148C"))
                    tvTemp.setTextColor(Color.parseColor("#D50000"))
                    tvDesc.setTextColor(Color.parseColor("#1A237E"))
                    tvHumidity.setTextColor(Color.parseColor("#006064"))
                    tvWind.setTextColor(Color.parseColor("#004D40"))
                    tvPressure.setTextColor(Color.parseColor("#BF360C"))
                }
            }

            containerLayout.addView(itemView)
        }

        return view
    }
}