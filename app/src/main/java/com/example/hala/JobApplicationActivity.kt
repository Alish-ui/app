package com.example.hala

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class JobApplicationActivity : AppCompatActivity() {

    private lateinit var etUserId: EditText
    private lateinit var etCountry: EditText
    private lateinit var etReferenceId: EditText
    private lateinit var etFullName: EditText
    private lateinit var btnSubmit: Button

    private lateinit var btnHost: Button
    private lateinit var btnAgent: Button
    private lateinit var btnAgency: Button
    private lateinit var btnBD: Button
    private lateinit var btnAdmin: Button
    private lateinit var btnManager: Button

    private lateinit var btnMale: Button
    private lateinit var btnFemale: Button

    private lateinit var btnMarried: Button
    private lateinit var btnUnmarried: Button

    private lateinit var rgExperience: RadioGroup
    private lateinit var rbYes: RadioButton
    private lateinit var rbNo: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_application)

        // Initialize UI components
        etUserId = findViewById(R.id.etUserId)
        etCountry = findViewById(R.id.etCountry)
        etReferenceId = findViewById(R.id.etReferenceId)
        etFullName = findViewById(R.id.etFullName)
        btnSubmit = findViewById(R.id.btnSubmit)

        btnHost = findViewById(R.id.btnHost)
        btnAgent = findViewById(R.id.btnAgent)
        btnAgency = findViewById(R.id.btnAgency)
        btnBD = findViewById(R.id.btnBD)
        btnAdmin = findViewById(R.id.btnAdmin)
        btnManager = findViewById(R.id.btnManager)

        btnMale = findViewById(R.id.rbMale)
        btnFemale = findViewById(R.id.rbFemale)

        btnMarried = findViewById(R.id.rbMarried)
        btnUnmarried = findViewById(R.id.rbUnmarried)

        rgExperience = findViewById(R.id.rgExperience)
        rbYes = findViewById(R.id.rbYes)
        rbNo = findViewById(R.id.rbNo)


        // Handle form submission
        btnSubmit.setOnClickListener {
            val userId = etUserId.text.toString().trim()
            val country = etCountry.text.toString().trim()
            val referenceId = etReferenceId.text.toString().trim()
            val fullName = etFullName.text.toString().trim()
            val experience = when {
                rbYes.isChecked -> "Yes"
                rbNo.isChecked -> "No"
                else -> ""
            }

            if (userId.isEmpty() || country.isEmpty() || referenceId.isEmpty() || fullName.isEmpty() || experience.isEmpty()) {
                Toast.makeText(this, "All fields must be filled!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Application Submitted!", Toast.LENGTH_SHORT).show()
            }
        }
    }


}