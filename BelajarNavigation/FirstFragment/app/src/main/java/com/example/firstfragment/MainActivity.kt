package com.example.firstfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

/*
    Fragment tuh simpel nya dia seperti kita pindah posisi activity dengan file xml lain, tapi kalau pakai ini
    kita gak usah buat semua activity tersebut,


*   kalau pakai fragment kita gak usah buat intent" lagi untuk pindah activity,
*   karena ini termasuk ke dalam activity
* */