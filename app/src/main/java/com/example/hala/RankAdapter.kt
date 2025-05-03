package com.example.hala

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RankAdapter(private val userList: List<UserRank>) :
    RecyclerView.Adapter<RankAdapter.RankViewHolder>() {

    class RankViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val rankText: TextView = view.findViewById(R.id.rankText)
        val profileImage: ImageView = view.findViewById(R.id.profileImage)
        val nameText: TextView = view.findViewById(R.id.nameText)
        val plusButton: Button = view.findViewById(R.id.plusButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user_rank, parent, false)
        return RankViewHolder(view)
    }

    override fun onBindViewHolder(holder: RankViewHolder, position: Int) {
        val user = userList[position]
        holder.rankText.text = user.rank.toString()
        holder.profileImage.setImageResource(user.profileImage)
        holder.nameText.text = user.name
    }

    override fun getItemCount(): Int = userList.size
}
