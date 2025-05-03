package com.example.hala

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TopUsersActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var topUserAdapter: TopUserAdapter
    private val userList = mutableListOf<TopUser>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_users)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerViewTopUsers)
        recyclerView.layoutManager = LinearLayoutManager(this)
        topUserAdapter = TopUserAdapter(userList)
        recyclerView.adapter = topUserAdapter

        // Back button click listener
        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            finish()
        }

        // Load user data
        loadUserData()
    }

    private fun loadUserData() {
        userList.apply {
            clear()
            add(TopUser("ALEXA", "❤️", R.drawable.img_10, false, 4, ""))
            add(TopUser("SAJID", "😇", R.drawable.img_40, false, 5, ""))
            add(TopUser("AIZA", "❤️", R.drawable.img_40, false, 6, ""))
            add(TopUser("SAJID", "😇", R.drawable.img_40, false, 5, ""))
            add(TopUser("SAJID", "😇", R.drawable.img_40, false, 5, ""))
        }
        topUserAdapter.notifyDataSetChanged() // ✅ Notify adapter
    }
}
