package com.example.hala

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PinListActivity : AppCompatActivity() {

    private lateinit var pinnedAdapter: UserAdapter
    private lateinit var followAdapter: UserAdapter
    private val pinnedUsers = mutableListOf<User>()
    private val followUsers = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin_list)

        val backButton: ImageView = findViewById(R.id.backButton)
        backButton.setOnClickListener { finish() }

        setupRecyclerViews()
        loadDummyData()
    }

    private fun setupRecyclerViews() {
        val pinnedRecyclerView = findViewById<RecyclerView>(R.id.pinnedRecyclerView)
        val followRecyclerView = findViewById<RecyclerView>(R.id.followRecyclerView)

        pinnedAdapter = UserAdapter(pinnedUsers, true) { user, action ->
            handleUserAction(user, action)
        }
        followAdapter = UserAdapter(followUsers, false) { user, action ->
            handleUserAction(user, action)
        }

        pinnedRecyclerView.layoutManager = LinearLayoutManager(this)
        pinnedRecyclerView.adapter = pinnedAdapter

        followRecyclerView.layoutManager = LinearLayoutManager(this)
        followRecyclerView.adapter = followAdapter

        val itemTouchHelper = ItemTouchHelper(UserDragCallback(pinnedAdapter))
        itemTouchHelper.attachToRecyclerView(pinnedRecyclerView)
    }

    private fun handleUserAction(user: User, action: String) {
        when (action) {
            "pin" -> {
                followUsers.remove(user)
                pinnedUsers.add(user)
            }
            "unpin" -> {
                pinnedUsers.remove(user)
                followUsers.add(user)
            }
        }
        pinnedAdapter.notifyDataSetChanged()
        followAdapter.notifyDataSetChanged()
    }

    private fun loadDummyData() {
        pinnedUsers.add(User("Alice", "Online", R.drawable.img, true, 1, "🔥"))
        pinnedUsers.add(User("Bob", "Offline", R.drawable.img, true, 2, "🌟"))
        followUsers.add(User("Charlie", "Busy", R.drawable.img, false, 3, "💬"))
        followUsers.add(User("David", "Online", R.drawable.img, false, 4, "🎵"))

        pinnedAdapter.notifyDataSetChanged()
        followAdapter.notifyDataSetChanged()
    }

}
