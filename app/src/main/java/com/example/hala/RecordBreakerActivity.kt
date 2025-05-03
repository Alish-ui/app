package com.example.hala

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecordBreakerActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record_breaker)

        recyclerView = findViewById(R.id.recordBreakerRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val dummyList = listOf(
            RecordBreakerData("Titanic Combo x 2500", "2022-08-22", "A new stream Kar Titanic combo record", "Combo must above 10000 dollar to appear", R.drawable.img_40, R.drawable.receiver_placeholder),
            RecordBreakerData("Villa Combo x 2500", "2022-08-22", "A new stream Kar Titanic combo record", "Combo must above 10000 dollar to appear", R.drawable.img_40, R.drawable.receiver_placeholder),
            RecordBreakerData("Celebration Combo x 2500", "2022-08-22", "A new stream Kar Titanic combo record", "Combo must above 10000 dollar to appear", R.drawable.img_40, R.drawable.receiver_placeholder)
        )

        recyclerView.adapter = RecordBreakerAdapter(dummyList)
    }
}
