package com.example.hala

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AfricaCountriesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AfricaCountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_africa_countries)

        recyclerView = findViewById(R.id.africaRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        val countries = listOf(
            AfricaCountry("Algeria", R.drawable.img_48),
            AfricaCountry("Angola", R.drawable.img_48),
            AfricaCountry("Benin", R.drawable.img_48),
            // Add all other countries and their flags
            AfricaCountry("Zimbabwe", R.drawable.img_48)
        )

        adapter = AfricaCountryAdapter(countries)
        recyclerView.adapter = adapter
    }
}
