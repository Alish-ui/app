package com.example.hala

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CoinStoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_store)

        val coinRecyclerView: RecyclerView = findViewById(R.id.recyclerViewCoins)

        val coinList = listOf(
            CoinItem("+500", R.drawable.img_3, "10,000", "$1.00"),
            CoinItem("+1000", R.drawable.img_3, "20,000", "$2.00"),
            CoinItem("+1500", R.drawable.img_3, "30,000", "$3.00"),
            CoinItem("+5000", R.drawable.img_3, "50,000", "$5.00"),
            CoinItem("+10000", R.drawable.img_3, "100,000", "$10.00"),
            CoinItem("+20000", R.drawable.img_3, "200,000", "$20.00"),
            CoinItem("+50000", R.drawable.img_3, "500,000", "$50.00"),
            CoinItem("+100000", R.drawable.img_3, "1,000,000", "$100.00"),
            CoinItem("+200000", R.drawable.img_3, "2,000,000", "$200.00"),
            CoinItem("+500000", R.drawable.img_3, "5,000,000", "$500.00"),
            CoinItem("+1000000", R.drawable.img_3, "11,000,000", "$1000.00"),
            CoinItem("+500000", R.drawable.img_3, "16,800,000", "$1500.00")
        )

        val adapter = CoinAdapter(coinList)
        coinRecyclerView.layoutManager = GridLayoutManager(this, 3)
        coinRecyclerView.adapter = adapter
    }
}
