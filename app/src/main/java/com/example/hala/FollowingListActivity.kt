package com.example.hala

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FollowingListActivity : AppCompatActivity() {

    private lateinit var searchBar: EditText
    private lateinit var sortSpinner: Spinner
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FollowingAdapter
    private val userList = mutableListOf<Users>()  // ✅ Changed User to Users

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_following_list)

        // Initialize Views
        searchBar = findViewById(R.id.searchBar)
        sortSpinner = findViewById(R.id.sortSpinner)
        recyclerView = findViewById(R.id.followingRecyclerView)
        val backButton: ImageView = findViewById(R.id.backButton)

        backButton.setOnClickListener { finish() }  // Close activity on back

        // Setup RecyclerView
        adapter = FollowingAdapter(userList) { user ->
            userList.remove(user)
            adapter.updateList(userList)
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Load Dummy Data
        loadUsers()

        // Setup Search
        searchBar.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                filterUsers(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        // Setup Sorting
        val sortingOptions = arrayOf("Most Active", "Most Recent", "Top Interactions")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, sortingOptions)
        sortSpinner.adapter = spinnerAdapter

        // ✅ Fixed: Using correct onItemSelectedListener
        sortSpinner.setOnItemSelectedListener(object : android.widget.AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: android.widget.AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                sortUsers(position)
            }
            override fun onNothingSelected(parent: android.widget.AdapterView<*>?) {}
        })
    }

    private fun loadUsers() {
        userList.add(Users("Alice", R.drawable.img_10, true, 120))  // ✅ Changed User to Users
        userList.add(Users("Bob", R.drawable.img, false, 80))
        userList.add(Users("Charlie", R.drawable.img, true, 200))
        userList.add(Users("David", R.drawable.img_10, false, 50))
        adapter.updateList(userList)
    }

    private fun filterUsers(query: String) {
        val filteredList = userList.filter { it.name.contains(query, ignoreCase = true) }
        adapter.updateList(filteredList)
    }

    private fun sortUsers(option: Int) {
        when (option) {
            0 -> userList.sortByDescending { it.isLive }
            1 -> userList.shuffle()
            2 -> userList.sortByDescending { it.interactionCount }
        }
        adapter.updateList(userList)
    }
}
