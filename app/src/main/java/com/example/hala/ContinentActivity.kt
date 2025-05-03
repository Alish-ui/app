package com.example.hala

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ContinentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_continent)

        val buttons = listOf(
            R.id.btnAsia to "Asia",
            R.id.btnAntarctica to "Antarctica",
            R.id.btnAustralia to "Australia",
            R.id.btnMiddleEast to "Middle East",
            R.id.btnEurope to "Europe",
            R.id.btnAfrica to "Africa",
            R.id.btnSouthAmerica to "South America",
            R.id.btnNorthAmerica to "North America"
        )

        for ((id, name) in buttons) {
            findViewById<Button>(id).setOnClickListener {
                Toast.makeText(this, "$name selected", Toast.LENGTH_SHORT).show()

                if (name == "Asia") {
                    val intent = Intent(this, AsiaCountriesActivity::class.java)
                    startActivity(intent)
                }
                if (name == "Africa") {
                    val intent = Intent(this, AfricaCountriesActivity::class.java)
                    startActivity(intent)
                }
                if (name == "Middle East") {
                    val intent = Intent(this, MiddleEastCountriesActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
