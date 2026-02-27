package com.example.fragmentdemo26

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity(),
    CitySelectDialogFragment.OnCitySelectedListener,
    DesignSelectDialogFragment.OnDesignSelectedListener {

    lateinit var fm: FragmentManager
    lateinit var toBrief: Button
    lateinit var toDetailed: Button
    lateinit var btnSelectCity: Button
    lateinit var btnSelectDesign: Button
    lateinit var tvCityTitle: TextView

    private var isBriefMode = true
    // 0 = светлая, 1 = тёмная, 2 = цветная
    private var currentDesign = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fm = supportFragmentManager

        toBrief = findViewById(R.id.btnBrief)
        toDetailed = findViewById(R.id.btnDetailed)
        btnSelectCity = findViewById(R.id.btnSelectCity)
        btnSelectDesign = findViewById(R.id.btnSelectDesign)
        tvCityTitle = findViewById(R.id.tvCityTitle)

        if (savedInstanceState != null) {
            isBriefMode = savedInstanceState.getBoolean("isBriefMode", true)
            currentDesign = savedInstanceState.getInt("currentDesign", 0)
            WeatherData.currentCity = savedInstanceState.getString("currentCity", "Москва")
        }

        updateCityTitle()

        if (savedInstanceState == null) {
            showCurrentFragment()
        }

        toBrief.setOnClickListener {
            isBriefMode = true
            showCurrentFragment()
        }

        toDetailed.setOnClickListener {
            isBriefMode = false
            showCurrentFragment()
        }

        btnSelectCity.setOnClickListener {
            val dialog = CitySelectDialogFragment()
            dialog.setOnCitySelectedListener(this)
            dialog.show(fm, "CitySelectDialog")
        }

        btnSelectDesign.setOnClickListener {
            val dialog = DesignSelectDialogFragment()
            dialog.setOnDesignSelectedListener(this)
            dialog.show(fm, "DesignSelectDialog")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("isBriefMode", isBriefMode)
        outState.putInt("currentDesign", currentDesign)
        outState.putString("currentCity", WeatherData.currentCity)
    }

    private fun showCurrentFragment() {
        val fragment = if (isBriefMode) {
            BriefWeatherFragment.newInstance(currentDesign)
        } else {
            DetailedWeatherFragment.newInstance(currentDesign)
        }

        fm.beginTransaction()
            .replace(R.id.container_fragm, fragment)
            .commit()
    }

    private fun updateCityTitle() {
        tvCityTitle.text = "Погода: ${WeatherData.currentCity}"
    }

    override fun onCitySelected(city: String) {
        updateCityTitle()
        showCurrentFragment()
    }

    override fun onDesignSelected(designIndex: Int) {
        currentDesign = designIndex
        showCurrentFragment()
    }
}