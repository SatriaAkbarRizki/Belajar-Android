package com.example.makanannusantara.ActivityOther

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.makanannusantara.R
import com.example.makanannusantara.databinding.ActivityDescriptionFoodBinding

class DescriptionFood : AppCompatActivity() {

    companion object{

        lateinit var binding: ActivityDescriptionFoodBinding
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_IMAGE = "extra_image"
        const val EXTRA_DESC = "extra_description"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description_food)
        setBInding()
        setData(binding)
    }


    fun setBInding() : View {
        binding = ActivityDescriptionFoodBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        return view
    }

    fun setData(binding: ActivityDescriptionFoodBinding){
        val name = intent.getStringExtra(EXTRA_NAME)
        val desc = intent.getStringExtra(EXTRA_DESC)
        val image = intent.getIntExtra(EXTRA_IMAGE, 0)

        binding.tvTittledec.text = name
        binding.tvDescriptionDesc.text = desc
        binding.imgDesc.setImageResource(image)
    }

}