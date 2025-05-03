package com.example.hala

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.hala.EditBasicInfoActivity


class ProfileEditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_edit)

        val ivBack = findViewById<ImageView>(R.id.ivBack)
        val ivEditProfile = findViewById<ImageView>(R.id.ivEditProfile)
        val ivAddPhoto = findViewById<ImageView>(R.id.ivAddPhoto)
        val tvEditInfo = findViewById<TextView>(R.id.tvEditInfo)

        // Handle back button
        ivBack.setOnClickListener {
            finish()
        }

        // Handle edit profile picture
        ivEditProfile.setOnClickListener {
            // Open gallery or camera to select a profile image
        }

        // Handle add photo album
        ivAddPhoto.setOnClickListener {
            // Open gallery to select images
        }

        tvEditInfo.paintFlags = tvEditInfo.paintFlags or android.graphics.Paint.UNDERLINE_TEXT_FLAG

        // Handle edit basic information
        tvEditInfo.setOnClickListener {
            // Open another activity to edit user details
            val intent = Intent(this, EditBasicInfoActivity::class.java)
            startActivity(intent)
        }
    }
}
