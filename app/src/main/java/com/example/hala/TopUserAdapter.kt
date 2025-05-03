package com.example.hala

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TopUserAdapter(private val userList: List<TopUser>) : RecyclerView.Adapter<TopUserAdapter.TopUserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopUserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_topuser, parent, false)
        return TopUserViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopUserViewHolder, position: Int) {
        val user = userList[position]
        holder.userName.text = user.name
        holder.userEmoji.text = user.emoji
        holder.userImage.setImageResource(user.imageResId)
    }

    override fun getItemCount(): Int = userList.size

    class TopUserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userName: TextView = view.findViewById(R.id.userName)
        val userEmoji: TextView = view.findViewById(R.id.userEmoji)
        val userImage: ImageView = view.findViewById(R.id.userImage)
    }
}


