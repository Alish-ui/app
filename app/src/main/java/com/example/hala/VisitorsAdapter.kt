package com.example.hala

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VisitorsAdapter(
    private val context: Context,
    private var visitorList: List<Visitor>
) : RecyclerView.Adapter<VisitorsAdapter.VisitorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VisitorViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_visitors, parent, false)
        return VisitorViewHolder(view)
    }

    override fun onBindViewHolder(holder: VisitorViewHolder, position: Int) {
        val visitor = visitorList[position]

        holder.visitorName.text = visitor.name
        holder.lastSeen.text = visitor.lastSeen
        holder.statusIndicator.visibility = if (visitor.isOnline) View.VISIBLE else View.GONE
        holder.badgeTopVisitor.visibility = if (visitor.isTopVisitor) View.VISIBLE else View.GONE
        holder.badgeGiftSender.visibility = if (visitor.isGiftSender) View.VISIBLE else View.GONE
    }

    override fun getItemCount(): Int = visitorList.size

    fun updateList(newList: List<Visitor>) {
        visitorList = newList
        notifyDataSetChanged()
    }

    class VisitorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val visitorName: TextView = view.findViewById(R.id.txtVisitorName)
        val lastSeen: TextView = view.findViewById(R.id.txtLastSeen)
        val statusIndicator: View = view.findViewById(R.id.statusIndicator)
        val badgeTopVisitor: ImageView = view.findViewById(R.id.imgTopVisitor)
        val badgeGiftSender: ImageView = view.findViewById(R.id.imgGiftSender)
    }
}
