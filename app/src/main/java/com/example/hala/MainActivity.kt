package com.example.hala

import android.content.Intent  // Add this import
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Ensure the ScrollView with ID 'main' exists before using it
        val rootView: View? = findViewById(R.id.main)

        rootView?.let {
            ViewCompat.setOnApplyWindowInsetsListener(it) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }

    fun openLevelScreen(view: View) {
        val intent = Intent(this, LevelActivity::class.java)
        startActivity(intent)
    }
    fun openVIP(view: View) {
        val intent = Intent(this, VIP::class.java)
        startActivity(intent)
    }
    fun openBadge(view: View) {
        val intent = Intent(this, Badge::class.java)
        startActivity(intent)
    }
    fun openMedal(view: View) {
        val intent = Intent(this, medal::class.java)
        startActivity(intent)
    }
    fun openBoard(view: View) {
        val intent = Intent(this, LeaderboardActivity::class.java)
        startActivity(intent)
    }
    fun openCoin(view: View) {
        val intent = Intent(this, ToplistActivity::class.java)
        startActivity(intent)
    } fun openFeedback(view: View) {
        val intent = Intent(this, ContinentActivity::class.java)
        startActivity(intent)
    }
    fun openCP(view: View) {
        val intent = Intent(this, CPDescriptionActivity::class.java)
        startActivity(intent)
    }
    fun openprofile(view: View) {
        val intent = Intent(this, profile::class.java)
        startActivity(intent)
    }
    fun openRecharge(view: View) {
        val intent = Intent(this, WWASRechargeActivity::class.java)
        startActivity(intent)
    }
    fun opentransfer(view: View) {
        val intent = Intent(this, transfer::class.java)
        startActivity(intent)
    }
    fun openaccess(view: View) {
        val intent = Intent(this, AccessCenterActivity::class.java)
        startActivity(intent)
    }
    fun openearning(view: View) {
        val intent = Intent(this, EarningCenterActivity::class.java)
        startActivity(intent)
    }
    fun openjob(view: View) {
        val intent = Intent(this, JobApplicationActivity::class.java)
        startActivity(intent)
    }
    fun openTASK(view: View) {
        val intent = Intent(this, TaskCenterActivity::class.java)
        startActivity(intent)
    }
    fun openvisit(view: View) {
        val intent = Intent(this, VisitorsActivity::class.java)
        startActivity(intent)
    }
    fun openedit(view: View) {
        val intent = Intent(this, ProfileEditActivity::class.java)
        startActivity(intent)
    }
    fun openle(view: View) {
        val intent = Intent(this, ContinentActivity::class.java)
        startActivity(intent)
    }

}
