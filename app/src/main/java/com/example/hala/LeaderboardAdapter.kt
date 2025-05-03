package com.example.hala

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.BaseAdapter

class LeaderboardAdapter(private val context: Context, private val items: List<LeaderboardItem>) : BaseAdapter() {

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Any = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_leaderboard, parent, false)

        val txtUsername: TextView = view.findViewById(R.id.txtUsername)
        val txtScore: TextView = view.findViewById(R.id.txtScore)
        val imgProfile: ImageView = view.findViewById(R.id.imgProfile)

        val item = items[position]

        txtUsername.text = item.username
        txtScore.text = item.score
        imgProfile.setImageResource(R.drawable.img) // Replace with real user image if available

        return view
    }
}
