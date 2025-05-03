package com.example.hala

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EarningCenterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_earning_center)

        val withdrawButton: Button = findViewById(R.id.withdrawButton)
        withdrawButton.setOnClickListener {
            Toast.makeText(this, "Withdraw request submitted!", Toast.LENGTH_SHORT).show()
        }
    }
}
