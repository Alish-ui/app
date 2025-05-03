package com.example.hala.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hala.R
import com.example.hala.model.CPStep

class CPStepAdapter(private val steps: List<CPStep>) :
    RecyclerView.Adapter<CPStepAdapter.CPStepViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CPStepViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cp_step, parent, false)
        return CPStepViewHolder(view)
    }

    override fun onBindViewHolder(holder: CPStepViewHolder, position: Int) {
        val step = steps[position]
        holder.title.text = step.title
        holder.description.text = step.description
        holder.image.setImageResource(step.imageResId)
    }

    override fun getItemCount(): Int = steps.size

    class CPStepViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tvStepTitle)
        val description: TextView = itemView.findViewById(R.id.tvStepDescription)
        val image: ImageView = itemView.findViewById(R.id.ivStepImage)
    }
}
