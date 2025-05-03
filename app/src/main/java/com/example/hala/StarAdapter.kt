package com.example.hala

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StarAdapter(private val starList: List<StarItem>) : RecyclerView.Adapter<StarAdapter.StarViewHolder>() {

    inner class StarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvRank: TextView = itemView.findViewById(R.id.tvRank)
        val imgGift: ImageView = itemView.findViewById(R.id.imgGift)
        val tvGiftName: TextView = itemView.findViewById(R.id.tvGiftName)
        val imgUser1: ImageView = itemView.findViewById(R.id.imgUser1)
        val imgUser2: ImageView = itemView.findViewById(R.id.imgUser2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_star, parent, false)
        return StarViewHolder(view)
    }

    override fun onBindViewHolder(holder: StarViewHolder, position: Int) {
        val item = starList[position]
        holder.tvRank.text = item.rank.toString()
        holder.tvGiftName.text = item.giftName
        holder.imgGift.setImageResource(item.giftImage)
    }

    override fun getItemCount() = starList.size
}
