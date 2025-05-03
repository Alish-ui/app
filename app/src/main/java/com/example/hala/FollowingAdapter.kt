package com.example.hala

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FollowingAdapter(
    private var userList: List<Users>,  // Changed User to Users
    private val onUnfollowClick: (Users) -> Unit
) : RecyclerView.Adapter<FollowingAdapter.FollowingViewHolder>() {

    class FollowingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profileImage: ImageView = view.findViewById(R.id.profileImage)
        val username: TextView = view.findViewById(R.id.username)
        val liveStatus: TextView = view.findViewById(R.id.liveStatus)
        val interactionStats: TextView = view.findViewById(R.id.interactionStats)
        val unfollowButton: Button = view.findViewById(R.id.unfollowButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_following_user, parent, false)
        return FollowingViewHolder(view)
    }

    override fun onBindViewHolder(holder: FollowingViewHolder, position: Int) {
        val user = userList[position]

        holder.profileImage.setImageResource(user.profilePicture)
        holder.username.text = user.name
        holder.liveStatus.visibility = if (user.isLive) View.VISIBLE else View.GONE
        holder.interactionStats.text = "Interactions: ${user.interactionCount}"
        holder.unfollowButton.setOnClickListener { onUnfollowClick(user) }
    }

    override fun getItemCount() = userList.size

    // ✅ Fix: Changed User to Users
    fun updateList(newList: List<Users>) {
        userList = newList
        notifyDataSetChanged()
    }
}
