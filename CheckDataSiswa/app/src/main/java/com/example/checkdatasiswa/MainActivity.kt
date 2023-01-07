package com.example.checkdatasiswa

import android.content.Intent
import android.graphics.drawable.AnimatedImageDrawable
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.TransitionDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startAnimateBackground()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        supportActionBar?.hide()
        showData()
    }

    fun showData()
    {
        val getDataSiswa = DataSiswa()

        btn_checkData.setOnClickListener {
            val name = inputSiswa.text.toString()
            getDataSiswa.setName(name)
            getDataSiswa.checkName()
            getDataSiswa.dataDetailSiswa()

            if (name.equals(DataSiswa.tostvalue))
            {
                switchActiviy()
            }
            else if (name.equals(DataSiswa.tostvalue).equals(false))
            {
                Toast.makeText(this@MainActivity, "Data tidak Ditemukan", Toast.LENGTH_SHORT).show()
            }

        }


    }

    fun switchActiviy()
    {
        startActivity(Intent(this@MainActivity, pageSecond::class.java))
        finish()
    }


    fun startAnimateBackground()
    {
        val layoutAnimate : AnimationDrawable = mainLayout.background as AnimationDrawable
        layoutAnimate.setEnterFadeDuration(2500)
        layoutAnimate.setExitFadeDuration(5000)
        layoutAnimate.start()
    }

}