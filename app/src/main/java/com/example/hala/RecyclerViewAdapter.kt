package com.example.hala

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Ensure this data class exists
data class LevelReward(
    val levelRange: String,
    val title: String,
    val rewards: String
)

class LevelRewardAdapter(private val rewardsList: List<LevelReward>) :
    RecyclerView.Adapter<LevelRewardAdapter.LevelRewardViewHolder>() {

    class LevelRewardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvLevelRange: TextView = view.findViewById(R.id.tvLevelRange)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvRewards: TextView = view.findViewById(R.id.tvRewards)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelRewardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_level_reward, parent, false)
        return LevelRewardViewHolder(view)
    }

    override fun onBindViewHolder(holder: LevelRewardViewHolder, position: Int) {
        val reward = rewardsList[position]
        holder.tvLevelRange.text = reward.levelRange
        holder.tvTitle.text = reward.title
        holder.tvRewards.text = reward.rewards
    }

    override fun getItemCount(): Int = rewardsList.size
}
