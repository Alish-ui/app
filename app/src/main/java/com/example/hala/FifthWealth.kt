package com.example.hala

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FifthWealth : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fifth_wealth)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun openFirstWealthScreen(view: View) {
        val intent = Intent(this, FirstWealthActivity::class.java)
        startActivity(intent)
    }
    // Function to open SecondWealthActivity
    fun openSecondWealthScreen(view: View) {
        val intent = Intent(this, SecondWealthActivity::class.java)
        startActivity(intent)
    }

    // Function to open ThirdWealthActivity
    fun openThirdWealth(view: View) {
        val intent = Intent(this, ThirdWealth::class.java)
        startActivity(intent)
    }

    // Function to open FourthWealthActivity
    fun openFourthWealth(view: View) {
        val intent = Intent(this, FourthWealth::class.java)
        startActivity(intent)
    }

    // Function to open FifthWealthActivity
    fun openFifthWealth(view: View) {
        val intent = Intent(this, FifthWealth::class.java)
        startActivity(intent)
    }
}