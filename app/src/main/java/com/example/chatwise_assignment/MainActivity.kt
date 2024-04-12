package com.example.chatwise_assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btn_products:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        btn_products=findViewById(R.id.btn_products)
        btn_products.setOnClickListener{
            val intent=Intent(this@MainActivity,Product_List::class.java)
            startActivity(intent)
        }

    }

}