package com.example.hala

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WeeklyStarsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var starAdapter: StarAdapter
    private lateinit var btnWeekly: Button
    private lateinit var btnLastWeek: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weekly_stars)

        recyclerView = findViewById(R.id.recyclerViewStars)
        btnWeekly = findViewById(R.id.btnWeekly)
        btnLastWeek = findViewById(R.id.btnLastWeek)

        setupRecyclerView()
        setupTabButtons()
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val starList = listOf(
            StarItem(4, "Fireworks", R.drawable.img_10),
            StarItem(5, "Diamond Ring", R.drawable.img_49),
            StarItem(6, "Fairy Peacock", R.drawable.img_40),
            StarItem(5, "Aeroplane", R.drawable.img_49),
            StarItem(5, "Rocket", R.drawable.img_49)
        )
        starAdapter = StarAdapter(starList)
        recyclerView.adapter = starAdapter
    }

    private fun setupTabButtons() {
        btnWeekly.setOnClickListener {
            // Change data if needed
        }
        btnLastWeek.setOnClickListener {
            // Change data if needed
        }
    }
}
