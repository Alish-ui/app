package com.example.hala

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PaymentMethodsActivity : AppCompatActivity() {

    private lateinit var recyclerViewPayments: RecyclerView
    private lateinit var recyclerViewAddPayments: RecyclerView
    private lateinit var backButton: ImageView
    private lateinit var userEmail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_methods)

        // Initialize views
        recyclerViewPayments = findViewById(R.id.recyclerViewPayments)
        recyclerViewAddPayments = findViewById(R.id.recyclerViewAddPayments)
        backButton = findViewById(R.id.btnBack)
        userEmail = findViewById(R.id.txtUserEmail)

        // Sample Data for Payment Methods
        val paymentMethods = listOf(
            PaymentMethod("Vodafone", R.drawable.img_35, true, ""),
            PaymentMethod("Visa-2580", R.drawable.img_36, false, ""),
            PaymentMethod("Mastercard-0027", R.drawable.img_36, false, ""),
            PaymentMethod("Vodafone", R.drawable.img_35, false, "verification needed"),
            PaymentMethod("Vodafone", R.drawable.img_35, false, "unavailable")
        )

        // Sample Data for Adding Payment Methods
        val addPaymentMethods = listOf(
            PaymentMethod("Add credit or debit card", R.drawable.img_36, false, ""),
            PaymentMethod("Add Vodafone billing1", R.drawable.img_35, false, ""),
            PaymentMethod("Add Vodafone billing2", R.drawable.img_35, false, "")
        )

        // Set up adapters
        recyclerViewPayments.layoutManager = LinearLayoutManager(this)
        recyclerViewPayments.adapter = PaymentAdapter(paymentMethods)

        recyclerViewAddPayments.layoutManager = LinearLayoutManager(this)
        recyclerViewAddPayments.adapter = PaymentAdapter(addPaymentMethods)

        // Handle back button
        backButton.setOnClickListener { finish() }
    }
}
