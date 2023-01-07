package com.example.implisitintent

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var dialNumber : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dialNumber = btn_DialNumber
        dialNumber.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v)
        {
            dialNumber ->{
                val phoneNumber = "089712312"

//                Intent.ACTION adalah action yang digunakan untuk membuka aplikasi lain
//                Uri adalah sebuah untaian karaktter atau simpel nya kode untuk menjalankan si Inten.ACTION tersebut

                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)

            }
        }

    }
}