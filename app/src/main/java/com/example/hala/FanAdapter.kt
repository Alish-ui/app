package com.example.hala

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FanAdapter(
    private var fanList: List<Fan>,
    private val onFanActionClick: (Fan) -> Unit
) : RecyclerView.Adapter<FanAdapter.FanViewHolder>() {

    class FanViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profileImage: ImageView = view.findViewById(R.id.profileImage)
        val username: TextView = view.findViewById(R.id.username)
        val fanBadge: TextView = view.findViewById(R.id.fanBadge)
        val interactionStats: TextView = view.findViewById(R.id.interactionStats)
        val messageButton: Button = view.findViewById(R.id.messageButton)
        val giftButton: Button = view.findViewById(R.id.giftButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FanViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fan, parent, false)
        return FanViewHolder(view)
    }

    override fun onBindViewHolder(holder: FanViewHolder, position: Int) {
        val fan = fanList[position]

        holder.profileImage.setImageResource(fan.profilePicture)
        holder.username.text = fan.name
        holder.fanBadge.text = fan.rankBadge
        holder.interactionStats.text = "Engagement: ${fan.engagementLevel}"
        holder.messageButton.setOnClickListener { onFanActionClick(fan) }
        holder.giftButton.setOnClickListener { onFanActionClick(fan) }
    }

    override fun getItemCount() = fanList.size

    fun updateList(newList: List<Fan>) {
        fanList = newList
        notifyDataSetChanged()
    }
}
