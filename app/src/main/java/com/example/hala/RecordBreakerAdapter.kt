package com.example.hala

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecordBreakerAdapter(private val list: List<RecordBreakerData>) :
    RecyclerView.Adapter<RecordBreakerAdapter.RecordViewHolder>() {

    inner class RecordViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.titleText)
        val date: TextView = view.findViewById(R.id.dateText)
        val message: TextView = view.findViewById(R.id.recordMessage)
        val condition: TextView = view.findViewById(R.id.recordCondition)
        val senderImage: ImageView = view.findViewById(R.id.senderImage)
        val receiverImage: ImageView = view.findViewById(R.id.receiverImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.record_breaker_item, parent, false)
        return RecordViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        val item = list[position]
        holder.title.text = item.comboTitle
        holder.date.text = item.date
        holder.message.text = item.recordMessage
        holder.condition.text = item.condition
        holder.senderImage.setImageResource(item.senderImageRes)
        holder.receiverImage.setImageResource(item.receiverImageRes)
    }

    override fun getItemCount(): Int = list.size
}
