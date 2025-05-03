package com.example.hala

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class FeedbackActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etNumber: EditText
    private lateinit var etEmail: EditText
    private lateinit var etFeedback: EditText
    private lateinit var spinnerFeedbackType: Spinner
    private lateinit var btnUploadImage: ImageButton
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        // Initialize Views
        etName = findViewById(R.id.etName)
        etNumber = findViewById(R.id.etNumber)
        etEmail = findViewById(R.id.etEmail)
        etFeedback = findViewById(R.id.etFeedback)
        spinnerFeedbackType = findViewById(R.id.spinnerFeedbackType)
        btnUploadImage = findViewById(R.id.btnUploadImage)
        btnSubmit = findViewById(R.id.btnSubmit)

        // Set up Spinner
        val feedbackOptions = arrayOf("Bug Report", "Feature Request", "General Feedback")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, feedbackOptions)
        spinnerFeedbackType.adapter = adapter

        // Submit Button Click Listener
        btnSubmit.setOnClickListener {
            val name = etName.text.toString()
            val number = etNumber.text.toString()
            val email = etEmail.text.toString()
            val feedback = etFeedback.text.toString()
            val feedbackType = spinnerFeedbackType.selectedItem.toString()

            if (name.isEmpty() || number.isEmpty() || email.isEmpty() || feedback.length < 10) {
                Toast.makeText(this, "Please fill all fields and write at least 10 words.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Feedback submitted successfully!", Toast.LENGTH_SHORT).show()
            }
        }

        // Upload Image Button Click Listener (Dummy)
        btnUploadImage.setOnClickListener {
            Toast.makeText(this, "Upload image clicked!", Toast.LENGTH_SHORT).show()
        }
    }
}
