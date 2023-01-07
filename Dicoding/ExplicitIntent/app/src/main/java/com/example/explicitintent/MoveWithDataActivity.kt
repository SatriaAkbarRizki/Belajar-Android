package com.example.explicitintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_move_with_data.*

class MoveWithDataActivity : AppCompatActivity() {

//    const val adalah sebuah val yang nilai nya bersifat tetap
    companion object
    {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_AGE = "extra_age"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

//        getStringExtra dan getIntEctra berfungsi untuk mengambil sebuah data dari intent
        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE,0)
        val textDataReceived = "Name You: $name, \nAge You: $age"
        tv_DataReceived.setText(textDataReceived)
    }
}