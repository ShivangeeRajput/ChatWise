package com.example.chatwise_assignment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Product_List : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_product_list)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)


        adapter = ProductAdapter(emptyList())
        recyclerView.adapter = adapter

        // Fetch data from API
        fetchDataFromAPI()
    }

    private fun fetchDataFromAPI() {
        val call = RetrofitInstance.apiInterface.getData()
        call.enqueue(object : Callback<responseDataClass> {
            override fun onResponse(call: Call<responseDataClass>, response: Response<responseDataClass>) {
                val responseData = response.body()
                if (responseData != null) {
                    updateUI(responseData.products)
                }
            }

            override fun onFailure(call: Call<responseDataClass>, t: Throwable) {

            }
        })
    }

    private fun updateUI(products: List<Product>) {
        adapter = ProductAdapter(products)
        recyclerView.adapter = adapter
    }
}
