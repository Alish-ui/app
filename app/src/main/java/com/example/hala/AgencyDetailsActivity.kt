package com.example.hala

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class AgencyDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agency_details)

        val applyButton: Button = findViewById(R.id.applyButton)
        applyButton.setOnClickListener {
            Toast.makeText(this, "Application Submitted!", Toast.LENGTH_SHORT).show()
        }
    }
}
