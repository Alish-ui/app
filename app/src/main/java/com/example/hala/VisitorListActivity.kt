package com.example.hala

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class VisitorListActivity : AppCompatActivity() {

    private lateinit var visitorRecyclerView: RecyclerView
    private lateinit var searchBar: EditText
    private lateinit var sortDropdown: Spinner
    private lateinit var anonymousSwitch: Switch
    private lateinit var backButton: ImageView
    private lateinit var visitorsAdapter: VisitorsAdapter

    private val visitorList = mutableListOf(
        Visitor("Alice", "ID123", R.drawable.img, R.drawable.flag_usa, "10:30 AM", "5 min ago", true, true, true),
        Visitor("Bob", "ID456", R.drawable.img, R.drawable.flag_usa, "10:25 AM", "10 min ago", false, false, true),
        Visitor("Charlie", "ID789", R.drawable.img, R.drawable.flag_usa, "10:15 AM", "15 min ago", true, true, false),
        Visitor("David", "ID101", R.drawable.img, R.drawable.flag_usa, "10:10 AM", "20 min ago", false, false, false)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visitor_list)

        // Initialize Views
        visitorRecyclerView = findViewById(R.id.recyclerViewVisitors)
        searchBar = findViewById(R.id.edtSearchVisitor)
        sortDropdown = findViewById(R.id.spinnerSortVisitor)
        anonymousSwitch = findViewById(R.id.switchAnonymousMode)
        backButton = findViewById(R.id.btnBack)

        // Set RecyclerView
        visitorsAdapter = VisitorsAdapter(this, visitorList)
        visitorRecyclerView.layoutManager = LinearLayoutManager(this)
        visitorRecyclerView.adapter = visitorsAdapter

        // Handle Back Button Click
        backButton.setOnClickListener { finish() }

        // Setup Sorting Dropdown
        val sortOptions = arrayOf("Most Recent", "Frequent Visitors", "Gift Senders")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, sortOptions)
        sortDropdown.adapter = adapter

        sortDropdown.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View?, position: Int, id: Long) {
                sortVisitors(position)
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        // Setup Search Filter
        searchBar.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                filterVisitors(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        // Handle Anonymous Mode Toggle
        anonymousSwitch.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, if (isChecked) "Anonymous Mode On" else "Anonymous Mode Off", Toast.LENGTH_SHORT).show()
        }
    }

    private fun filterVisitors(query: String) {
        val filteredList = visitorList.filter { it.name.contains(query, ignoreCase = true) }
        visitorsAdapter.updateList(filteredList)
    }

    private fun sortVisitors(position: Int) {
        val sortedList = when (position) {
            0 -> visitorList.sortedByDescending { it.lastSeen }
            1 -> visitorList.sortedByDescending { it.isTopVisitor }
            2 -> visitorList.sortedByDescending { it.isGiftSender }
            else -> visitorList
        }
        visitorsAdapter.updateList(sortedList)
    }
}
