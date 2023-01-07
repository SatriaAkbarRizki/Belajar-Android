package com.example.checkdatasiswa

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        supportActionBar?.hide()

        Handler().postDelayed(
            {
                val intent = Intent(this@SplashScreenActivity,MainActivity::class.java)
                startActivity(intent)
                finish()
            },3000
        )
    }
}