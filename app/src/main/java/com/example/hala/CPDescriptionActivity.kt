package com.example.hala

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hala.adapter.CPStepAdapter
import com.example.hala.model.CPStep

class CPDescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cpdescription)


        val btnBack: ImageView = findViewById(R.id.btnBack)

        btnBack.setOnClickListener { finish() }

        val steps = listOf(
            CPStep(
                "Step 2: Pair1",
                "Both users have to complete gift points and live activity points.\n30000 Gifting Point",
                R.drawable.img_4
            ),
            CPStep(
                "Monday One:",
                "One chat, one hour continuous interaction with each other (e.g., chat, gaming or spending time in a room for one week).",
                R.drawable.img_4
            ),
            CPStep(
                "Monday Two: Pair2",
                "In the second week, both users have to complete gift points and live activity points. 100000 Gifting Point.",
                R.drawable.img_4
            ),
            CPStep(
                "Pair Three",
                "In the third week, both will spend more time together in a room or chat. Both users have to complete gift points and live activity points.",
                R.drawable.img_4
            ),
            CPStep(
                "Step 3: CP Activation",
                "After completion of the process, both users will apply, and permanent issuance of CP will be granted by the system.",
                R.drawable.img_4
            )
        )


    }
}
