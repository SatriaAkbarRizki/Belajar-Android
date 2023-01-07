package com.example.distrolinux

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {


    private lateinit var back : ImageButton

    companion object{
        const val EXTRA_NAME ="extra_name"
        const val EXTRA_IMAGE = "extra_image"
        const val EXTRA_DESCRIPTION = "extra_description"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val name = intent.getStringExtra(EXTRA_NAME)
        val image = intent.getIntExtra(EXTRA_IMAGE,0)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)


        val textSet : TextView = findViewById(R.id.tv_textTitleDistro)
        val imageSet : ImageView = findViewById(R.id.img_photoDetailActivity)
        val descriptionSet : TextView = findViewById(R.id.tv_textDescriptionDetail)


        textSet.text = name
        imageSet.setImageResource(image)
        descriptionSet.text = description

        back = findViewById(R.id.btn_backActivity)
        val backActivityMain = Intent(this@DetailActivity, MainActivity::class.java)
        back.setOnClickListener {
            startActivity(backActivityMain)
            finish()
        }
    }
}