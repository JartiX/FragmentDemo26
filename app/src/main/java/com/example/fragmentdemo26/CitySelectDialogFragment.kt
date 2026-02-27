package com.example.fragmentdemo26

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class CitySelectDialogFragment : DialogFragment() {
    interface OnCitySelectedListener {
        fun onCitySelected(city: String)
    }

    private var listener: OnCitySelectedListener? = null

    fun setOnCitySelectedListener(listener: OnCitySelectedListener) {
        this.listener = listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val cities = WeatherData.availableCities
        val currentIndex = cities.indexOf(WeatherData.currentCity).coerceAtLeast(0)

        return AlertDialog.Builder(requireContext())
            .setTitle("Выберите город")
            .setIcon(R.drawable.ic_partly_cloudy)
            .setSingleChoiceItems(cities, currentIndex) { dialog, which ->
                val selectedCity = cities[which]
                WeatherData.currentCity = selectedCity
                listener?.onCitySelected(selectedCity)
                dialog.dismiss()
            }
            .setNegativeButton("Отмена") { dialog, _ ->
                dialog.cancel()
            }
            .create()
    }
}