package com.example.hala

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class LevelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)
    }

    fun openFirstWealthScreen(view: View) {
        val intent = Intent(this, FirstWealthActivity::class.java)
        startActivity(intent)
    }
    fun  openSecondWealthScreen(view: View) {
        val intent = Intent(this, Talent::class.java)
        startActivity(intent)
    }
}
