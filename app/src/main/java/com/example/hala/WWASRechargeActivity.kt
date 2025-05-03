package com.example.hala

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hala.adapter.RechargeAdapter
import com.example.hala.model.RechargeItem
import android.widget.ArrayAdapter
import android.widget.Spinner

class WWASRechargeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wwasrecharge)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewRecharge)
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        val rechargeItems = listOf(
            RechargeItem("+500", "10000", "$1.00", R.drawable.img),
            RechargeItem("+1000", "20000", "$2.00", R.drawable.img),
            RechargeItem("+1500", "30000", "$3.00", R.drawable.img),
            RechargeItem("+5000", "50000", "$5.00", R.drawable.img),
            RechargeItem("+10000", "100000", "$10.00", R.drawable.img),
            RechargeItem("+20000", "200000", "$20.00", R.drawable.img),
            RechargeItem("+50000", "500000", "$50.00", R.drawable.img),
            RechargeItem("+100000", "1000000", "$100.00", R.drawable.img),
            RechargeItem("+200000", "2000000", "$200.00", R.drawable.img),
            RechargeItem("+500000", "5000000", "$500.00", R.drawable.img),
            RechargeItem("+1000000", "10000000", "$1000.00", R.drawable.img),
        )

        recyclerView.adapter = RechargeAdapter(rechargeItems)

    }
}
