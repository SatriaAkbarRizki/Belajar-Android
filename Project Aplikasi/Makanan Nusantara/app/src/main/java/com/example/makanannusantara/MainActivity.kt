package com.example.makanannusantara

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.makanannusantara.databinding.ActivityMainBinding
import com.example.makanannusantara.databinding.FragmentHomeActivityBinding

class MainActivity : AppCompatActivity() {

    private val listFood = ArrayList<DataFood>()
    private lateinit var  rvFood : RecyclerView

    companion object{
        lateinit var bindingHome : FragmentHomeActivityBinding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main)
        val navController = this.findNavController(R.id.navhost_fragment)

        AppCompatDelegate.setDefaultNightMode(
            AppCompatDelegate.MODE_NIGHT_NO
        )

        bindingHome = FragmentHomeActivityBinding.inflate(layoutInflater)
        val view2 = bindingHome.root
        setContentView(view2)

        rvFood = bindingHome.rvFood
        listFood.addAll(setListFood())
        showRecyclerView()

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController =this.findNavController(R.id.navhost_fragment)
        return navController.navigateUp()
    }

    private fun setListFood() : ArrayList<DataFood>
    {
        val nameFood = resources.getStringArray(R.array.nameFoodArray)
        val imageFood = ArrayList<Int>()


        imageFood.add (R.drawable.nasi_lemak)
        imageFood.add (R.drawable.rendang)
        imageFood.add (R.drawable.sate)
        imageFood.add (R.drawable.semur_ayam)

        val getFood = ArrayList<DataFood>()

        for (i in nameFood.indices){
            var collect = DataFood(nameFood.get(i), imageFood.get(i))
            getFood.add(collect)
        }
        return getFood
    }

    private fun showRecyclerView()
    {
        rvFood.layoutManager = LinearLayoutManager(this)
        val customAdapter = CustomAdapter(listFood)
        rvFood.adapter = customAdapter
        rvFood.layoutManager = GridLayoutManager(this, 2)
    }

}