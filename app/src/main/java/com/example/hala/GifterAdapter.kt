package com.example.hala

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GifterAdapter(
    private var gifterList: List<Gifter>,
    private val onInteractClick: (Gifter) -> Unit
) : RecyclerView.Adapter<GifterAdapter.GifterViewHolder>() {

    class GifterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profileImage: ImageView = view.findViewById(R.id.profileImage)
        val username: TextView = view.findViewById(R.id.username)
        val gifterRanking: TextView = view.findViewById(R.id.gifterRanking)
        val giftStats: TextView = view.findViewById(R.id.giftStats)
        val lastGiftDate: TextView = view.findViewById(R.id.lastGiftDate)
        val liveIndicator: ImageView = view.findViewById(R.id.liveIndicator)
        val messageButton: Button = view.findViewById(R.id.messageButton)
        val sendGiftButton: Button = view.findViewById(R.id.sendGiftButton)
        val thankYouButton: Button = view.findViewById(R.id.thankYouButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_gifter, parent, false)
        return GifterViewHolder(view)
    }

    override fun onBindViewHolder(holder: GifterViewHolder, position: Int) {
        val gifter = gifterList[position]

        holder.profileImage.setImageResource(gifter.profilePicture)
        holder.username.text = gifter.name
        holder.gifterRanking.text = gifter.ranking
        holder.giftStats.text = "Gifts Sent: ${gifter.totalGifts}"
        holder.lastGiftDate.text = "Last Gift: ${gifter.lastGiftDate}"
        holder.liveIndicator.visibility = if (gifter.isLive) View.VISIBLE else View.GONE

        holder.messageButton.setOnClickListener { onInteractClick(gifter) }
        holder.sendGiftButton.setOnClickListener { onInteractClick(gifter) }
        holder.thankYouButton.setOnClickListener { onInteractClick(gifter) }
    }

    override fun getItemCount() = gifterList.size

    fun updateList(newList: List<Gifter>) {
        gifterList = newList
        notifyDataSetChanged()
    }
}
