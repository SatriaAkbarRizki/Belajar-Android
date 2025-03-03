package com.example.learningforegroud

import android.Manifest
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.learningforegroud.service.RunningService

class MainActivity : AppCompatActivity() {
    private lateinit var buttonStart : Button
    private lateinit var buttonStop : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Log.i("Status Activity", "Activity OnCreate")

        initView()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                0
            )
        }

        clickActionButton()
    }

    private fun initView(){
        buttonStart = findViewById(R.id.buttonStart)
        buttonStop = findViewById(R.id.buttonStop)
    }

    private fun clickActionButton(){
        buttonStart.setOnClickListener {
            Intent(applicationContext, RunningService::class.java).also {
                it.action = RunningService.Actions.START.toString()
                startService(it)
            }
        }


        buttonStop.setOnClickListener {
            Intent(applicationContext, RunningService::class.java).also {
                it.action = RunningService.Actions.STOP.toString()
                startService(it)
            }
        }

    }

}