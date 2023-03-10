package com.example.makanannusantara

import android.content.Intent
import android.graphics.Color
import android.os.Build
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
import java.util.concurrent.locks.Condition

class MainActivity : AppCompatActivity(), ClickToActivity {

    private val listFood = ArrayList<DataFood>()
    private lateinit var rvFood: RecyclerView
    private var checkMode: Boolean = false
    lateinit var customAdapter : CustomAdapter
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setBinding()
        AppCompatDelegate.setDefaultNightMode(
            AppCompatDelegate.MODE_NIGHT_NO
        )

        rvFood = binding.rvFood
        listFood.addAll(setListFood())
        showRecyclerView()
        supportActionBar?.hide()
    }

    private fun setBinding(): View {
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
        val view = binding.root
        return view
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
        customAdapter = CustomAdapter(listFood, this)
        rvFood.adapter = customAdapter
        switchMode()

    }

    override fun onClickItemActivity(position: Int) {
        val intent = Intent(this@MainActivity, DescriptionFood::class.java)
        intent.putExtra(DescriptionFood.EXTRA_NAME, listFood[position].nameFood)
        intent.putExtra(DescriptionFood.EXTRA_IMAGE, listFood[position].imageFood)
        intent.putExtra(DescriptionFood.EXTRA_DESC, listFood[position].descriptionFood)
        startActivity(intent)
    }

    fun switchMode() {
        binding.btnSwitchLayout.setOnClickListener {
            if (checkMode == false) {
                val adapterGrid = AdapterGrid(listFood, this)
                rvFood.layoutManager = GridLayoutManager(this, 2)
                rvFood.adapter = adapterGrid
                checkMode = true

            } else if (checkMode == true) {
                checkMode = false
                rvFood.adapter = customAdapter
                rvFood.layoutManager = LinearLayoutManager(this)

            }
        }
    }
}


