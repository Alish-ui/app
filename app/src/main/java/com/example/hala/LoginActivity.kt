package com.example.hala

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Ensure the layout file exists
        val btnGoogleLogin: LinearLayout? = findViewById(R.id.btnGoogleLogin)
        val btnFacebookLogin: LinearLayout? = findViewById(R.id.btnFacebookLogin)

        btnGoogleLogin?.setOnClickListener {
            Toast.makeText(this, "Google Login Clicked", Toast.LENGTH_SHORT).show()
        }

        btnFacebookLogin?.setOnClickListener {
            Toast.makeText(this, "Facebook Login Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}
