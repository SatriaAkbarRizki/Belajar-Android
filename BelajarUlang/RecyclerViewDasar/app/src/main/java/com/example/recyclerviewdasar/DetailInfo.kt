package com.example.recyclerviewdasar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView

class DetailInfo : AppCompatActivity() {

    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_IMAGE = "extra_image"
        const val EXTRA_DESC = "extra_description"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_info)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()

        val name = intent.getStringExtra(EXTRA_NAME)
        val image = intent.getIntExtra(EXTRA_IMAGE, 0)
        val desc = intent.getStringExtra(EXTRA_DESC)

        val nameCity : TextView = findViewById(R.id.tv_namaKotaDetail)
        val imageCity : ImageView = findViewById(R.id.img_imageCityDetail)
        val descCity : TextView = findViewById(R.id.tv_descriptionCity)

        nameCity.text = name
        imageCity.setImageResource(image)
        descCity.text = desc
    }
}