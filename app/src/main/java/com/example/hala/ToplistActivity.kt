package com.example.hala

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class ToplistActivity : AppCompatActivity() {

    private lateinit var backButton: ImageView
    private lateinit var topUsersSection: LinearLayout
    private lateinit var newstarSection: LinearLayout
    private var toptalentSection: LinearLayout? = null
    private lateinit var gameSection: LinearLayout
    private lateinit var comboSection: LinearLayout
    private lateinit var recordbreakerSection: LinearLayout
    private lateinit var weeklystarSection: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toplist)

        // Initialize Views
        backButton = findViewById(R.id.btnBack)
        topUsersSection = findViewById(R.id.topUsersSection)
        newstarSection = findViewById(R.id.newstarSection)
        toptalentSection = findViewById(R.id.toptalentSection)
        gameSection = findViewById(R.id.gameSection)
        comboSection = findViewById(R.id.comboSection)
        recordbreakerSection = findViewById(R.id.recordbreakerSection)
        weeklystarSection = findViewById(R.id.weeklystarSection)


        // Back button
        backButton.setOnClickListener { finish() }

        // Section Click Handlers
        topUsersSection.setOnClickListener {
            startActivity(Intent(this, TopUsersActivity::class.java))
        }

        toptalentSection?.setOnClickListener {
            startActivity(Intent(this, TopTalentActivity::class.java))
        }

        newstarSection.setOnClickListener {
            startActivity(Intent(this, NewStarsActivity::class.java))
        }

        gameSection.setOnClickListener {
            startActivity(Intent(this, GameWinnersActivity::class.java))
        }

        comboSection.setOnClickListener {
            startActivity(Intent(this, ComboSentActivity::class.java))
        }

        recordbreakerSection.setOnClickListener {
            startActivity(Intent(this, RecordBreakerActivity::class.java))
        }

        weeklystarSection.setOnClickListener {
            startActivity(Intent(this, WeeklyStarsActivity::class.java))
        }
    }
}
