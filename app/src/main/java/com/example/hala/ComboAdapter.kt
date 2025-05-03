package com.example.hala

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ComboAdapter(private val comboList: List<ComboData>) :
    RecyclerView.Adapter<ComboAdapter.ComboViewHolder>() {

    inner class ComboViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val comboTitle: TextView = view.findViewById(R.id.comboTitle)
        val comboDate: TextView = view.findViewById(R.id.comboDate)
        val senderImage: ImageView = view.findViewById(R.id.senderImage)
        val receiverImage: ImageView = view.findViewById(R.id.receiverImage)
        val senderName: TextView = view.findViewById(R.id.senderName)
        val receiverName: TextView = view.findViewById(R.id.receiverName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComboViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.combo_item, parent, false)
        return ComboViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComboViewHolder, position: Int) {
        val item = comboList[position]
        holder.comboTitle.text = "${item.comboName} X${item.quantity}"
        holder.comboDate.text = item.date
        holder.senderName.text = item.senderName
        holder.receiverName.text = item.receiverName
        holder.senderImage.setImageResource(item.senderImageRes)
        holder.receiverImage.setImageResource(item.receiverImageRes)
    }

    override fun getItemCount(): Int = comboList.size
}
