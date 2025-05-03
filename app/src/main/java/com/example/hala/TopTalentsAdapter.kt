package com.example.hala

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TopTalentsAdapter(private val talentList: List<Talent>) :
    RecyclerView.Adapter<TopTalentsAdapter.TalentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TalentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_toptalent, parent, false)
        return TalentViewHolder(view)
    }

    override fun onBindViewHolder(holder: TalentViewHolder, position: Int) {
        val talent = talentList[position]
        holder.bind(talent)
    }

    override fun getItemCount(): Int = talentList.size

    class TalentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameText: TextView = itemView.findViewById(R.id.talentName)
        private val profileImage: ImageView = itemView.findViewById(R.id.profileImage)
        private val scoreText: TextView = itemView.findViewById(R.id.talentScore) // ✅ Fix: Now matches XML

        fun bind(talent: Talent) {
            nameText.text = talent.name
            scoreText.text = talent.score
            profileImage.setImageResource(talent.imageRes)
        }
    }

}
