package com.example.hala

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class LeaderboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leaderboard)

        // Example data for the leaderboard
        val leaderboardData = listOf(
            LeaderboardItem("❤️ ALEXA ❤️", "37.00k"),
            LeaderboardItem("😇 SAJID", "37.00k"),
            LeaderboardItem("❤️ AIZA ❤️", "37.00k"),
            LeaderboardItem("😇 SAJID", "37.00k"),
            LeaderboardItem("😇 SAJID", "37.00k")
        )

        val listView: ListView = findViewById(R.id.listLeaderboard)
        val adapter = LeaderboardAdapter(this, leaderboardData)
        listView.adapter = adapter
    }
}
