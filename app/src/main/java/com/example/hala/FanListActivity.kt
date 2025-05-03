package com.example.hala

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FanListActivity : AppCompatActivity() {

    private lateinit var searchBar: EditText
    private lateinit var sortSpinner: Spinner
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FanAdapter
    private val fanList = mutableListOf<Fan>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fan_list)

        // Initialize Views
        searchBar = findViewById(R.id.searchBar)
        sortSpinner = findViewById(R.id.sortSpinner)
        recyclerView = findViewById(R.id.fanRecyclerView)
        val backButton: ImageView = findViewById(R.id.backButton)

        backButton.setOnClickListener { finish() } // Close activity on back

        // Setup RecyclerView
        adapter = FanAdapter(fanList) { fan -> /* Handle interactions */ }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Load Dummy Data
        loadFans()

        // Setup Search
        searchBar.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                filterFans(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        // Setup Sorting
        val sortingOptions = arrayOf("Recent", "Top Gifters", "Most Active")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, sortingOptions)
        sortSpinner.adapter = spinnerAdapter

        sortSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                sortFans(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }
    }

    private fun loadFans() {
        fanList.add(Fan("Alice", R.drawable.img_10, "🏆", 120))
        fanList.add(Fan("Bob", R.drawable.img, "🥈", 95))
        fanList.add(Fan("Charlie", R.drawable.img, "🥉", 85))
        fanList.add(Fan("David", R.drawable.img_10, "🌟", 60))
        adapter.updateList(fanList)
    }

    private fun filterFans(query: String) {
        val filteredList = fanList.filter { it.name.contains(query, ignoreCase = true) }
        adapter.updateList(filteredList)
    }

    private fun sortFans(option: Int) {
        when (option) {
            0 -> fanList.shuffle()
            1 -> fanList.sortByDescending { it.engagementLevel }
            2 -> fanList.sortByDescending { it.engagementLevel }
        }
        adapter.updateList(fanList)
    }
}
