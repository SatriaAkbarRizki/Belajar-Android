package com.example.makanannusantara

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.makanannusantara.ActivityOther.DescriptionFood
import com.example.makanannusantara.Data.ClickToActivity
import com.example.makanannusantara.Data.DataFood
import com.example.makanannusantara.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ClickToActivity {

    private val listFood = ArrayList<DataFood>()
    private lateinit var rvFood: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
        val view = binding.root

        AppCompatDelegate.setDefaultNightMode(
            AppCompatDelegate.MODE_NIGHT_NO
        )


        rvFood = binding.rvFood
        listFood.addAll(setListFood())
        showRecyclerView()
        supportActionBar?.hide()
    }


    private fun setListFood(): ArrayList<DataFood> {

        val nameFood = resources.getStringArray(R.array.nameFoodArray)
        val descFood = resources.getStringArray(R.array.deskipsiNama)
        val imageFood = ArrayList<Int>()
        imageFood.add(R.drawable.nasi_lemak)
        imageFood.add(R.drawable.rendang)
        imageFood.add(R.drawable.sate)
        imageFood.add(R.drawable.semur_ayam)

        val getFood = ArrayList<DataFood>()

        for (i in nameFood.indices) {
            var collect = DataFood(nameFood.get(i), imageFood.get(i), descFood.get(i))
            getFood.add(collect)
        }
        return getFood
    }

    private fun showRecyclerView() {
        rvFood.layoutManager = LinearLayoutManager(this)
        val customAdapter = CustomAdapter(listFood, this)

        rvFood.adapter = customAdapter
        rvFood.layoutManager = GridLayoutManager(this, 2)
    }

    override fun onClickItemActivity(position: Int) {
        val intent = Intent(this@MainActivity, DescriptionFood::class.java)
        intent.putExtra(DescriptionFood.EXTRA_NAME, listFood[position].nameFood)
        intent.putExtra(DescriptionFood.EXTRA_IMAGE, listFood[position].imageFood)
        intent.putExtra(DescriptionFood.EXTRA_DESC, listFood[position].descriptionFood)
        startActivity(intent)
    }

}