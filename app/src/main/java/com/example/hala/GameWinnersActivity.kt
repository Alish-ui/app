package com.example.hala

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GameWinnersActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_winners)

        recyclerView = findViewById(R.id.winnersRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val winners = listOf(
            GameWinnerData("Aryan12", "17", "2022-08-22 18:27", "57,600,000", R.drawable.img_40, true),
            GameWinnerData("ID 4 Seal", "17", "2022-08-22 18:27", "37,600,000", R.drawable.img_10, false),
            GameWinnerData("Usama312", "17", "2022-08-22 18:27", "17,600,000", R.drawable.img_40, false),
            GameWinnerData("fiza312", "17", "2022-08-22 18:27", "17,600,000", R.drawable.img_40, false)
        )

        recyclerView.adapter = GameWinnerAdapter(winners)
    }
}
