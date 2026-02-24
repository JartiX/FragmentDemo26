package com.example.fragmentdemo26

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    lateinit var fm: FragmentManager
    lateinit var briefFragment: Fragment
    lateinit var detailedFragment: Fragment
    lateinit var toBrief: Button
    lateinit var toDetailed: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fm = supportFragmentManager
        detailedFragment = DetailedWeatherFragment()

        val existing = fm.findFragmentById(R.id.container_fragm)
        if (existing == null) {
            briefFragment = BriefWeatherFragment()
            fm.beginTransaction()
                .add(R.id.container_fragm, briefFragment)
                .commit()
        } else {
            briefFragment = existing
        }

        toBrief = findViewById(R.id.btnBrief)
        toDetailed = findViewById(R.id.btnDetailed)

        toBrief.setOnClickListener {
            fm.beginTransaction()
                .replace(R.id.container_fragm, briefFragment)
                .commit()
        }

        toDetailed.setOnClickListener {
            fm.beginTransaction()
                .replace(R.id.container_fragm, detailedFragment)
                .commit()
        }
    }
}