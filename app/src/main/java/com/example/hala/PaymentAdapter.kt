package com.example.hala

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PaymentAdapter(private val paymentList: List<PaymentMethod>) :
    RecyclerView.Adapter<PaymentAdapter.PaymentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_payment_method, parent, false)
        return PaymentViewHolder(view)
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        val paymentMethod = paymentList[position]
        holder.paymentIcon.setImageResource(paymentMethod.icon)
        holder.paymentName.text = paymentMethod.name

        if (paymentMethod.status.isNotEmpty()) {
            holder.paymentStatus.text = paymentMethod.status
            holder.paymentStatus.visibility = View.VISIBLE
        } else {
            holder.paymentStatus.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return paymentList.size
    }

    class PaymentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val paymentIcon: ImageView = view.findViewById(R.id.imgPaymentIcon)
        val paymentName: TextView = view.findViewById(R.id.txtPaymentName)
        val paymentStatus: TextView = view.findViewById(R.id.txtPaymentStatus)
    }
}
