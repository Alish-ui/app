package com.example.hala

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AppCompatActivity


class ComboSentActivity : AppCompatActivity() {

    private lateinit var comboRecyclerView: RecyclerView
    private lateinit var adapter: ComboAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_combo_sent)

        comboRecyclerView = findViewById(R.id.comboRecyclerView)
        comboRecyclerView.layoutManager = LinearLayoutManager(this)

        val dummyData = listOf(
            ComboData("Ultimate Romance Combo", 1, "2022-08-22 18:27", "DON.ACO", "Malik12", R.drawable.img_10, R.drawable.img_40),
            ComboData("Aeroplane combo", 1, "2022-08-22 18:27", "DON.ACO", "Malik12", R.drawable.img_10, R.drawable.img_40),
            ComboData("Ultimate Romance Combo", 1, "2022-08-22 18:27", "DON.ACO", "Malik12", R.drawable.img_10, R.drawable.img_40)
        )

        adapter = ComboAdapter(dummyData)
        comboRecyclerView.adapter = adapter
    }
}
