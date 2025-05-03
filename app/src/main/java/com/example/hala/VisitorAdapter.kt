package com.example.hala.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hala.R
import com.example.hala.Visitor

class VisitorAdapter(private val visitors: List<Visitor>) :
    RecyclerView.Adapter<VisitorAdapter.VisitorViewHolder>() {

    class VisitorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivProfile: ImageView = view.findViewById(R.id.ivProfile)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvID: TextView = view.findViewById(R.id.tvID)
        val ivFlag: ImageView = view.findViewById(R.id.ivFlag)
        val tvTimestamp: TextView = view.findViewById(R.id.tvTimestamp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VisitorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_visitor, parent, false)
        return VisitorViewHolder(view)
    }

    override fun onBindViewHolder(holder: VisitorViewHolder, position: Int) {
        val visitor = visitors[position]
        holder.tvName.text = visitor.name
        holder.tvID.text = "ID: ${visitor.id}"
        holder.ivProfile.setImageResource(visitor.profileImage)
        holder.ivFlag.setImageResource(visitor.flag)
        holder.tvTimestamp.text = visitor.timestamp
    }

    override fun getItemCount(): Int = visitors.size
}
