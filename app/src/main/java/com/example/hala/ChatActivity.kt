package com.example.hala

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ChatActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageView
    private lateinit var imgProfile: ImageView
    private lateinit var txtUserName: TextView
    private lateinit var btnFollow: Button
    private lateinit var btnMenu: ImageView
    private lateinit var edtMessage: EditText
    private lateinit var btnEmoji: ImageView
    private lateinit var btnSend: Button
    private lateinit var btnVoice: ImageView
    private lateinit var btnImage: ImageView
    private lateinit var btnGift: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        // Initialize Views
        btnBack = findViewById(R.id.btnBack)
        imgProfile = findViewById(R.id.imgProfile)
        txtUserName = findViewById(R.id.txtUserName)
        btnFollow = findViewById(R.id.btnFollow)
        btnMenu = findViewById(R.id.btnMenu)
        edtMessage = findViewById(R.id.edtMessage)
        btnEmoji = findViewById(R.id.btnEmoji)
        btnSend = findViewById(R.id.btnSend)
        btnVoice = findViewById(R.id.btnVoice)
        btnImage = findViewById(R.id.btnImage)
        btnGift = findViewById(R.id.btnGift)

        // Set user name from intent
        val userName = intent.getStringExtra("user_name")
        txtUserName.text = userName ?: "User"

        // Back button functionality
        btnBack.setOnClickListener { finish() }

        // Follow button toggle
        btnFollow.setOnClickListener {
            if (btnFollow.text == "Follow") {
                btnFollow.text = "Following"
                Toast.makeText(this, "You are now following $userName", Toast.LENGTH_SHORT).show()
            } else {
                btnFollow.text = "Follow"
                Toast.makeText(this, "Unfollowed $userName", Toast.LENGTH_SHORT).show()
            }
        }

        // Send message functionality
        btnSend.setOnClickListener {
            val message = edtMessage.text.toString().trim()
            if (message.isNotEmpty()) {
                Toast.makeText(this, "Message sent: $message", Toast.LENGTH_SHORT).show()
                edtMessage.text.clear()
            }
        }
    }
}
