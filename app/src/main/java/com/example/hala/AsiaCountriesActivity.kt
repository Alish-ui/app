package com.example.hala

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AsiaCountriesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AsiaCountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asia_countries)

        recyclerView = findViewById(R.id.asiaRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        val countries = listOf(
            AsiaCountry("Afghanistan", R.drawable.img_48),
            AsiaCountry("Armenia", R.drawable.img_48),
            AsiaCountry("Azerbaijan", R.drawable.img_48),
            AsiaCountry("Bangladesh", R.drawable.img_48),
            AsiaCountry("Bhutan", R.drawable.img_48),
            AsiaCountry("Brunei", R.drawable.img_48),
            AsiaCountry("Cambodia", R.drawable.img_48),
            AsiaCountry("China", R.drawable.img_48),
            AsiaCountry("Georgia", R.drawable.img_48),
            AsiaCountry("Hongkong", R.drawable.img_48),
            AsiaCountry("India", R.drawable.img_48),
            AsiaCountry("Indonesia", R.drawable.img_48),
            AsiaCountry("Israel", R.drawable.img_48),
            AsiaCountry("Japan", R.drawable.img_48),
            AsiaCountry("Kazakhstan", R.drawable.img_48),
            AsiaCountry("North Korea", R.drawable.img_48),
            AsiaCountry("South Korea", R.drawable.img_48),
            AsiaCountry("Kyrgyzstan", R.drawable.img_48),
            AsiaCountry("Laos", R.drawable.img_48),
            AsiaCountry("Macau", R.drawable.img_48),
            AsiaCountry("Malaysia", R.drawable.img_48),
            AsiaCountry("Maldives", R.drawable.img_48),
            AsiaCountry("Mongolia", R.drawable.img_48),
            AsiaCountry("Maynmar", R.drawable.img_48),
            AsiaCountry("Nepal", R.drawable.img_48),
            AsiaCountry("Pakistan", R.drawable.img_48),
            AsiaCountry("Philippines", R.drawable.img_48),
            AsiaCountry("Russia", R.drawable.img_48),
            AsiaCountry("Singapur", R.drawable.img_48),
            AsiaCountry("Srilanka", R.drawable.img_48),
            AsiaCountry("Taiwan", R.drawable.img_48),
            AsiaCountry("Tajikistan", R.drawable.img_48),
            AsiaCountry("Thailand", R.drawable.img_48),
            AsiaCountry("Timor Leste", R.drawable.img_48),
            AsiaCountry("Turkey", R.drawable.img_48),
            AsiaCountry("Turkmenistan", R.drawable.img_48),
            AsiaCountry("Uzbekistan", R.drawable.img_48),
            AsiaCountry("Vietnam", R.drawable.img_48)
        )

        adapter = AsiaCountryAdapter(countries)
        recyclerView.adapter = adapter
    }
}
