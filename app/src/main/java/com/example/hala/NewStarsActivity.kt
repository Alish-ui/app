package com.example.hala

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NewStarsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RankAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_stars)

        recyclerView = findViewById(R.id.rankRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val sampleData = listOf(
            UserRank(4, "ALEXA", R.drawable.img_49),
            UserRank(5, "SAJID", R.drawable.img_49),
            UserRank(6, "AIZA", R.drawable.img_49),
            UserRank(5, "SAJID", R.drawable.img_49),
            UserRank(5, "SAJID", R.drawable.img_49)
        )

        adapter = RankAdapter(sampleData)
        recyclerView.adapter = adapter
    }
}
