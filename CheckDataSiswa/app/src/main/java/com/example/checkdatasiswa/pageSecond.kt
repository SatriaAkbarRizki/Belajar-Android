package com.example.checkdatasiswa

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_page2.*

class pageSecond : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        supportActionBar?.hide()
        showDataSiswa()
        switchBackActivity()
    }

    fun showDataSiswa()
    {
        val getData = DataSiswa()

        dataNamaSiswa.setText(DataSiswa.nameSiswa)
        dataNISN_NIS.setText(DataSiswa.nisn_nisSiswa)
        imageSiswaShow.setBackgroundResource(DataSiswa.sourceImage!!)
    }

    fun switchBackActivity()
    {
        btn_backActivity.setOnClickListener {
            startActivity(Intent(this@pageSecond, MainActivity::class.java))
            finish()
        }
    }
}
