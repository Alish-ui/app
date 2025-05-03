package com.example.hala

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RoomSettingsActivity : AppCompatActivity() {
    private lateinit var roomName: EditText
    private lateinit var roomTopic: EditText
    private lateinit var roomCover: ImageView
    private lateinit var startBroadcast: Button
    private lateinit var themeButtons: List<Button>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_settings)

        roomName = findViewById(R.id.roomName)
        roomTopic = findViewById(R.id.roomTopic)
        roomCover = findViewById(R.id.roomCover)
        startBroadcast = findViewById(R.id.startBroadcast)

        val themeSocial: Button = findViewById(R.id.themeSocial)
        val themeChat: Button = findViewById(R.id.themeChat)
        val themeGame: Button = findViewById(R.id.themeGame)
        val themeMusic: Button = findViewById(R.id.themeMusic)

        themeButtons = listOf(themeSocial, themeChat, themeGame, themeMusic)

        themeButtons.forEach { button ->
            button.setOnClickListener { selectTheme(button) }
        }

        roomCover.setOnClickListener {
            // Simulate picking an image (Implement actual image picker)
            Toast.makeText(this, "Set Room Cover Clicked", Toast.LENGTH_SHORT).show()
        }

        startBroadcast.setOnClickListener {
            val name = roomName.text.toString()
            val topic = roomTopic.text.toString()

            if (name.isEmpty() || topic.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Broadcast Started!", Toast.LENGTH_SHORT).show()
                // Implement actual broadcast logic
            }
        }
    }

    private fun selectTheme(selectedButton: Button) {
        themeButtons.forEach { it.setBackgroundColor(Color.DKGRAY) }
        selectedButton.setBackgroundColor(Color.BLUE)
    }
}
