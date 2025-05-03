package com.example.hala

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TaskCenterActivity : AppCompatActivity() {

    private lateinit var rvCheckInCalendar: RecyclerView
    private lateinit var btnCheckInMain: Button
    private lateinit var tvCheckInDays: TextView
    private lateinit var sbBonusProgress: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_center)

        // Initialize Views
        val ivBack = findViewById<ImageView>(R.id.ivBack)
        val btnCheckIn = findViewById<Button>(R.id.btnCheckIn)
        rvCheckInCalendar = findViewById(R.id.rvCheckInCalendar)
        btnCheckInMain = findViewById(R.id.btnCheckInMain)
        tvCheckInDays = findViewById(R.id.tvCheckInDays)
        sbBonusProgress = findViewById(R.id.sbBonusProgress)

        // Handle Back Button Click
        ivBack.setOnClickListener { finish() }


        rvCheckInCalendar.layoutManager = GridLayoutManager(this, 4)

        val spacing = resources.getDimensionPixelSize(R.dimen.spacing_24dp)

        rvCheckInCalendar.addItemDecoration(GridSpacingItemDecoration(4, 24, true))

        rvCheckInCalendar.adapter = CheckInAdapter(getCheckInData())

        // Handle Check-in Click
        btnCheckInMain.setOnClickListener {
            Toast.makeText(this, "Checked in!", Toast.LENGTH_SHORT).show()
        }

        // SeekBar Progress Change
        sbBonusProgress.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvCheckInDays.text = "You have checked in continuously for $progress days"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    private fun getCheckInData(): List<CheckInItem> {
        return (1..30).map { day ->
            CheckInItem(day, if (day % 5 == 0) "Bonus" else "${day * 50} coins")
        }
    }
}
