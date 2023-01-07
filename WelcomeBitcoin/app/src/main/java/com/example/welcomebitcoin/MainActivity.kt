package com.example.welcomebitcoin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()    // Pakai ini biar nama applikasi di bar tidak muncul

        Handler().postDelayed(
            {
                // Cara pakai Splash Screen Android
                val intent = Intent(this@MainActivity, HomeActivity::class.java)
                startActivity(intent)
                finish()

            },3000
        )
    }

}