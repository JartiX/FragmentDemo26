package com.example.fragmentdemo26

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class BriefWeatherFragment : Fragment() {

    companion object {
        private const val ARG_DESIGN = "design_index"

        fun newInstance(designIndex: Int): BriefWeatherFragment {
            val fragment = BriefWeatherFragment()
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
        val view = inflater.inflate(R.layout.fragment_brief_weather, container, false)
        val containerLayout = view.findViewById<LinearLayout>(R.id.briefContainer)
        val designIndex = arguments?.getInt(ARG_DESIGN, 0) ?: 0

        when (designIndex) {
            0 -> view.setBackgroundColor(Color.parseColor("#E3F2FD"))
            1 -> view.setBackgroundColor(Color.parseColor("#263238"))
            2 -> view.setBackgroundColor(Color.parseColor("#E8F5E9"))
        }

        for (day in WeatherData.forecast) {
            val itemView = inflater.inflate(R.layout.item_brief_weather, containerLayout, false)

            val tvDay = itemView.findViewById<TextView>(R.id.tvBriefDay)
            val ivIcon = itemView.findViewById<ImageView>(R.id.ivWeatherIcon)
            val tvTemp = itemView.findViewById<TextView>(R.id.tvBriefTemp)

            tvDay.text = day.dayOfWeek.take(3)
            ivIcon.setImageResource(day.iconResId)
            tvTemp.text = "${day.temperature}°C"

            when (designIndex) {
                1 -> {
                    itemView.setBackgroundColor(Color.parseColor("#37474F"))
                    tvDay.setTextColor(Color.WHITE)
                    tvTemp.setTextColor(Color.parseColor("#80CBC4"))
                }
                2 -> {
                    itemView.setBackgroundColor(Color.parseColor("#C8E6C9"))
                    tvDay.setTextColor(Color.parseColor("#1B5E20"))
                    tvTemp.setTextColor(Color.parseColor("#E65100"))
                }
            }

            containerLayout.addView(itemView)
        }

        return view
    }
}