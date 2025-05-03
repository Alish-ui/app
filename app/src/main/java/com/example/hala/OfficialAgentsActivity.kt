package com.example.hala

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OfficialAgentsActivity : AppCompatActivity() {

    private lateinit var recyclerViewAgents: RecyclerView
    private lateinit var agentsAdapter: AgentsAdapter
    private lateinit var backButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_official_agents)

        recyclerViewAgents = findViewById(R.id.recyclerViewAgents)
        backButton = findViewById(R.id.btnBack)

        // Sample Data
        val agentsList = listOf(
            Agent("9064844", 624, R.drawable.img),
            Agent("9052341", 540, R.drawable.img),
            Agent("9036789", 712, R.drawable.img_10),
            Agent("9023456", 389, R.drawable.img_10),
            Agent("9087612", 820, R.drawable.img_10)
        )

        agentsAdapter = AgentsAdapter(this, agentsList)
        recyclerViewAgents.layoutManager = LinearLayoutManager(this)
        recyclerViewAgents.adapter = agentsAdapter

        // Handle Back Button
        backButton.setOnClickListener { finish() }
    }
}
