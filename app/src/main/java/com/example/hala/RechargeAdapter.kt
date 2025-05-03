

package com.example.hala.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hala.R
import com.example.hala.model.RechargeItem

class RechargeAdapter(private val items: List<RechargeItem>) :
    RecyclerView.Adapter<RechargeAdapter.RechargeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RechargeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recharge, parent, false)
        return RechargeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RechargeViewHolder, position: Int) {
        val item = items[position]
        holder.bonus.text = item.bonus
        holder.coins.text = item.coins
        holder.price.text = item.price
        holder.image.setImageResource(item.imageResId)
    }

    override fun getItemCount(): Int = items.size

    class RechargeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bonus: TextView = itemView.findViewById(R.id.tvBonus)
        val coins: TextView = itemView.findViewById(R.id.tvCoins)
        val price: TextView = itemView.findViewById(R.id.tvPrice)
        val image: ImageView = itemView.findViewById(R.id.ivCoinImage)
    }
}
