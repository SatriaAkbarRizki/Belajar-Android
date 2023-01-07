package com.example.imagewelcome

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonMethod()
    {
        val button1 = findViewById<Button>(R.id.Btn1)
        val button2 = findViewById<Button>(R.id.Btn2)

    }
}