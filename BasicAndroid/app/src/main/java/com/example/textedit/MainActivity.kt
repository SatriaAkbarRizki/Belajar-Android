package com.example.textedit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Btn1.setOnClickListener {
            val textName = inputName.text.toString()
            val numberNISN = inputNISN.text.toString()

            outputName.setText(textName)        // Untuk set value String dari variable yang di deklerasi
            outputNISN.setText(numberNISN)
        }
    }
}