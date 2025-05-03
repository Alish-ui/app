package com.example.hala

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TopTalentActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var talentList: ArrayList<Talent>
    private lateinit var adapter: TopTalentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_talent)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        talentList = arrayListOf(
            Talent("❤️ ALEXA ❤️", "370.0K", R.drawable.img_40),
            Talent("😇 SAJID", "365.0K", R.drawable.img_10),
            Talent("❤️ AIZA ❤️", "355.0K", R.drawable.img_10),
            Talent("😇 SAJID", "345.0K", R.drawable.img_10)
        )

        adapter = TopTalentsAdapter(talentList)
        recyclerView.adapter = adapter
    }
}
