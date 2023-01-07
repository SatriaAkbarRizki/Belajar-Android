package com.example.explicitintent

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_move_with_data.*
import kotlinx.android.synthetic.main.activity_move_with_objek.*

class MoveWithObjekActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_objek)


        val person = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_PERSON, Person::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_PERSON)
        }

//      Tampilkan data nya ke TextView
        if (person != null) {
            val text = "Name: ${person.name}, \nEmail: ${person.email}, \nAge: ${person.age}," +
                    "\nCity: ${person.city}"
            tv_DataObjek.text = text
        }
    }
}

//  todo
//  lanjutin solving tadi, tinggal ambil datanya aj