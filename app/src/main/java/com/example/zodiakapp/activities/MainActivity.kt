package com.example.zodiakapp.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zodiakapp.HoroscopeAdapter
import com.example.zodiakapp.R
import com.example.zodiakapp.data.Horoscope
import com.example.zodiakapp.data.HoroscopeProvider

class MainActivity : AppCompatActivity() {


    val horoscopeList = HoroscopeProvider.getAll()

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerView = findViewById(R.id.recyclerView)

        val adapter = HoroscopeAdapter(horoscopeList, { position ->
            val horoscope =horoscopeList[position]

val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("Horoscope_ID", horoscope.id)
            startActivity(intent)
            //Log.i ("Click", "He hecho click en un ${horoscope.id}")
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }


}