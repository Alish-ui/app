package com.example.hala

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GifterListActivity : AppCompatActivity() {

    private lateinit var searchBar: EditText
    private lateinit var sortSpinner: Spinner
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: GifterAdapter
    private val gifterList = mutableListOf<Gifter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gifter_list)

        // Initialize Views
        searchBar = findViewById(R.id.edtSearchGifter)
        sortSpinner = findViewById(R.id.spinnerSortGifter)
        recyclerView = findViewById(R.id.recyclerViewGifters)
        val backButton: ImageView = findViewById(R.id.btnBack)

        backButton.setOnClickListener { finish() } // Close activity on back

        // Setup RecyclerView
        adapter = GifterAdapter(gifterList) { gifter -> /* Handle interactions */ }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Load Dummy Data
        loadGifters()

        // Setup Search
        searchBar.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                filterGifters(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        // Setup Sorting
        val sortingOptions = arrayOf("Top Gifters", "Recent Gifters", "Most Frequent")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, sortingOptions)
        sortSpinner.adapter = spinnerAdapter

        sortSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                sortGifters(position)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun loadGifters() {
        gifterList.add(Gifter("Alice", R.drawable.img_10, "🏆", 150, "2 hours ago", true))
        gifterList.add(Gifter("Bob", R.drawable.img, "🥈", 120, "5 hours ago", false))
        gifterList.add(Gifter("Charlie", R.drawable.img, "🥉", 100, "Yesterday", false))
        gifterList.add(Gifter("David", R.drawable.img_10, "🌟", 80, "Today", true))
        adapter.updateList(gifterList)
    }

    private fun filterGifters(query: String) {
        val filteredList = gifterList.filter { it.name.contains(query, ignoreCase = true) }
        adapter.updateList(filteredList)
    }

    private fun sortGifters(option: Int) {
        when (option) {
            0 -> gifterList.sortByDescending { it.totalGifts }
            1 -> gifterList.shuffle()
            2 -> gifterList.sortByDescending { it.totalGifts }
        }
        adapter.updateList(gifterList)
    }
}
