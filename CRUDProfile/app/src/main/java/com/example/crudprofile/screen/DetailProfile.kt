package com.example.crudprofile.screen

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.crudprofile.R
import com.example.crudprofile.model.PeopleModel

class DetailProfile : AppCompatActivity() {
    private lateinit var name : TextView
    private lateinit var address : TextView
    private lateinit var imagePeople : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_profile)
        initView()
        retriveExtraIntent()
    }

    override fun onStart() {
        super.onStart()
    }


    private fun initView(){
        name = findViewById(R.id.nameDetail)
        address = findViewById(R.id.addressDetail)
        imagePeople = findViewById(R.id.imagePeopleDetail)
    }


    private fun retriveExtraIntent(){
        val results = intent.getParcelableExtra<PeopleModel>("ValueDetailProfile")!!
        Log.i("Value Retrive", results.toString())
        setValueOnView(results)
    }

    private fun setValueOnView(peopleModel: PeopleModel){
        name.text = peopleModel.name
        address.text = peopleModel.address
        Glide.with(this).load(peopleModel.avatar)
            .placeholder(R.drawable.placeholder_card)
            .error(R.drawable.placeholder_card)
            .into(imagePeople)
    }


}