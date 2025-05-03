package com.example.hala

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CoinAdapter(private val coinList: List<CoinItem>) :
    RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {

    class CoinViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtBonus: TextView = view.findViewById(R.id.txtBonus)
        val imgCoin: ImageView = view.findViewById(R.id.imgCoin)
        val txtAmount: TextView = view.findViewById(R.id.txtAmount)
        val txtPrice: TextView = view.findViewById(R.id.txtPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_coin, parent, false)
        return CoinViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val item = coinList[position]
        holder.txtBonus.text = item.bonus
        holder.imgCoin.setImageResource(item.imageRes)
        holder.txtAmount.text = item.amount
        holder.txtPrice.text = item.price
    }

    override fun getItemCount() = coinList.size
}
