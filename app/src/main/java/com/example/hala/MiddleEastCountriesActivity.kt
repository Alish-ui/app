package com.example.hala

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MiddleEastCountriesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MiddleEastCountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_middle_east_countries)

        recyclerView = findViewById(R.id.middleEastRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        val countries = listOf(
            MiddleEastCountry("Bahrain", R.drawable.img_48),
            MiddleEastCountry("Cyprus", R.drawable.img_48),
            MiddleEastCountry("Egypt", R.drawable.img_48),
            MiddleEastCountry("Iran", R.drawable.img_48),
            MiddleEastCountry("Iraq", R.drawable.img_48),
            MiddleEastCountry("Jordan", R.drawable.img_48),
            MiddleEastCountry("Kuwait", R.drawable.img_48),
            MiddleEastCountry("Lebanon", R.drawable.img_48),
            MiddleEastCountry("Oman", R.drawable.img_48),
            MiddleEastCountry("Palestine", R.drawable.img_48),
            MiddleEastCountry("Qatar", R.drawable.img_48),
            MiddleEastCountry("Saudi Arabia", R.drawable.img_48),
            MiddleEastCountry("Syria", R.drawable.img_48),
            MiddleEastCountry("(UAE)", R.drawable.img_48),
            MiddleEastCountry("Yemen", R.drawable.img_48),
            MiddleEastCountry("Morocco", R.drawable.img_48)
        )

        adapter = MiddleEastCountryAdapter(countries)
        recyclerView.adapter = adapter
    }
}
