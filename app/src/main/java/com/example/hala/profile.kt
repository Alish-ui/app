package com.example.hala

import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Finding views
        val btnInvite: Button = findViewById(R.id.btnInvite)
        val userID: TextView = findViewById(R.id.userID)
        val supportersGrid: GridLayout = findViewById(R.id.supportersGrid)
        val badgesGrid: GridLayout = findViewById(R.id.badgesGrid)

        // Set user ID text
        userID.text = "ID NO: 9209496"

        // Invite button click listener
        btnInvite.setOnClickListener {
            Toast.makeText(this, "Invite Sent!", Toast.LENGTH_SHORT).show()
        }

        // Dynamically adding supporter images
        for (i in 1..10) {
            val imageView = ImageView(this)
            imageView.setImageResource(R.drawable.img)
            imageView.layoutParams = GridLayout.LayoutParams().apply {
                width = 50
                height = 50
                setMargins(5, 5, 5, 5)
            }
            supportersGrid.addView(imageView)
        }

        // Dynamically adding badge images
        for (i in 1..8) {
            val imageView = ImageView(this)
            imageView.setImageResource(R.drawable.img)
            imageView.layoutParams = GridLayout.LayoutParams().apply {
                width = 50
                height = 50
                setMargins(5, 5, 5, 5)
            }
            badgesGrid.addView(imageView)
        }
    }
}