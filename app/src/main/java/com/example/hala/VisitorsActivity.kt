package com.example.hala

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hala.adapters.VisitorAdapter


class VisitorsActivity : AppCompatActivity() {

    private lateinit var rvVisitors: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visitors)

        // Initialize Views
        val ivBack = findViewById<ImageView>(R.id.ivBack)
        rvVisitors = findViewById(R.id.rvVisitors)

        // Handle Back Button
        ivBack.setOnClickListener { finish() }

        // Set up RecyclerView
        rvVisitors.layoutManager = LinearLayoutManager(this)
        rvVisitors.adapter = VisitorAdapter(getVisitorsList())
    }

    private fun getVisitorsList(): List<Visitor> {
        return listOf(
            Visitor("ALEXA", "986365492", R.drawable.img_10, R.drawable.flag_singapore, "2025-04-03 13:45", "5 min ago", true, true, false),
            Visitor("SAJID", "986365492", R.drawable.img_10, R.drawable.flag_usa, "2025-04-03 14:30", "10 min ago", false, false, true),
            Visitor("AIZA", "986365492", R.drawable.img_10, R.drawable.flag_usa, "2025-04-03 12:15", "15 min ago", true, false, false),
            Visitor("SAJID", "986365492", R.drawable.img_10, R.drawable.flag_singapore, "2025-04-03 18:20", "20 min ago", false, true, true)
        )
    }

}
