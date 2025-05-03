package com.example.hala

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GameWinnerAdapter(private val list: List<GameWinnerData>) :
    RecyclerView.Adapter<GameWinnerAdapter.WinnerViewHolder>() {

    inner class WinnerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val crown: ImageView = view.findViewById(R.id.crownIcon)
        val userImage: ImageView = view.findViewById(R.id.userImage)
        val userName: TextView = view.findViewById(R.id.userName)
        val level: TextView = view.findViewById(R.id.levelText)
        val winText: TextView = view.findViewById(R.id.winText)
        val date: TextView = view.findViewById(R.id.dateText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WinnerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_game_winner, parent, false)
        return WinnerViewHolder(view)
    }

    override fun onBindViewHolder(holder: WinnerViewHolder, position: Int) {
        val item = list[position]
        holder.userImage.setImageResource(item.imageRes)
        holder.userName.text = item.name
        holder.level.text = "LV${item.level}"
        holder.winText.text = "Won By ${item.beansWon} beans!"
        holder.date.text = item.date
        holder.crown.visibility = if (item.isCrowned) View.VISIBLE else View.GONE
    }

    override fun getItemCount(): Int = list.size
}
