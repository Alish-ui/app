package com.example.hala

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AgentsAdapter(private val context: Context, private val agentsList: List<Agent>) :
    RecyclerView.Adapter<AgentsAdapter.AgentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_agent, parent, false)
        return AgentViewHolder(view)
    }

    override fun onBindViewHolder(holder: AgentViewHolder, position: Int) {
        val agent = agentsList[position]
        holder.agentName.text = agent.id
        holder.recentOrders.text = "Recent orders: ${agent.recentOrders}"
        holder.agentImage.setImageResource(agent.profileImage)

        // Handle Connect Button Click
        holder.connectButton.setOnClickListener {
            val intent = Intent(context, ChatActivity::class.java)
            intent.putExtra("user_name", agent.id) // Passing agent ID as name
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return agentsList.size
    }

    class AgentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val agentImage: ImageView = view.findViewById(R.id.imgProfile)
        val agentName: TextView = view.findViewById(R.id.txtAgentId)
        val recentOrders: TextView = view.findViewById(R.id.txtRecentOrders)
        val connectButton: Button = view.findViewById(R.id.btnConnect)
    }
}
