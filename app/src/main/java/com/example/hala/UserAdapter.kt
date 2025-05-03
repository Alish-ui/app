package com.example.hala

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(
    private val users: MutableList<User>,
    private val isPinnedList: Boolean,
    private val onUserAction: (User, String) -> Unit
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage: ImageView = itemView.findViewById(R.id.profileImage)
        val username: TextView = itemView.findViewById(R.id.username)
        val status: TextView = itemView.findViewById(R.id.status)
        val pinButton: ImageView = itemView.findViewById(R.id.pinButton)
        val dragHandle: ImageView = itemView.findViewById(R.id.dragHandle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.profileImage.setImageResource(user.imageRes)
        holder.username.text = user.name
        holder.status.text = user.status
        holder.pinButton.setImageResource(if (isPinnedList) R.drawable.img_20 else R.drawable.img_18)
        holder.dragHandle.visibility = if (isPinnedList) View.VISIBLE else View.GONE

        holder.pinButton.setOnClickListener {
            val action = if (isPinnedList) "unpin" else "pin"
            onUserAction(user, action)
        }
    }

    override fun getItemCount(): Int = users.size
}
