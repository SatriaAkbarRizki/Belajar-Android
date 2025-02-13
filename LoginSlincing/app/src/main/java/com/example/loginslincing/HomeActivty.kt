package com.example.loginslincing

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginslincing.model.LoginModel

class HomeActivty : AppCompatActivity() {
    lateinit var listUser : ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_activty)
        val results = intent.getParcelableArrayListExtra<LoginModel>("ListUser")
        Log.i("Results User", results.toString())

        listUser = findViewById(R.id.listUser)
        val getEmail = results!!.map { it.Email }
        listUser.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, getEmail)

    }
}