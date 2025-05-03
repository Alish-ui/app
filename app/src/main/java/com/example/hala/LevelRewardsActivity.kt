package com.example.hala

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LevelRewardsActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: LevelRewardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_rewards)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val rewardsList = listOf(
            LevelReward("(Lv. 1-5)", "Bronze Novice", "Basic welcome badge, daily login rewards..."),
            LevelReward("(Lv. 6-10)", "Bronze Warrior", "Bronze badge, exclusive emoji pack..."),
            LevelReward("(Lv. 11-15)", "Silver Apprentice", "Silver badge, small coin reward..."),
            LevelReward("(Lv. 16-20)", "Silver Challenger", "Silver badge upgrade, animated gift..."),
            LevelReward("(Lv. 21-25)", "Gold Explorer", "Gold badge, custom avatar frame..."),
            LevelReward("(Lv. 26-30)", "Gold Gladiator", "Animated gold badge, exclusive sound effect..."),
            LevelReward("(Lv. 31-35)", "Platinum Rookie", "Platinum badge, free coin gift pack..."),
            LevelReward("(Lv. 36-40)", "Platinum Elite", "Animated platinum badge, premium emoji pack..."),
            LevelReward("(Lv. 41-45)", "Diamond Hunter", "100,000 coins bonus, special animated frame...")
        )

        adapter = LevelRewardAdapter(rewardsList)
        recyclerView.adapter = adapter
    }
}
