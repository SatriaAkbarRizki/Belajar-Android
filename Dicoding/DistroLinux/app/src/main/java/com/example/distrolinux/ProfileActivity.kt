package com.example.distrolinux

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageButton

class ProfileActivity : AppCompatActivity() {

    private lateinit var back : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        back = findViewById(R.id.btn_backActivity)
        val backActivityMain = Intent(this@ProfileActivity, MainActivity::class.java)
        back.setOnClickListener{
            startActivity(backActivityMain)
            finish()
        }
    }
}