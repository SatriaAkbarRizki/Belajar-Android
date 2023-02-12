package com.example.recyclerviewdasar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdasar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val listKota = ArrayList<Kota>()
    private lateinit var rvKota: RecyclerView

    companion object{
        lateinit var binding : ActivityMainBinding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        rvKota = binding.recyclerView
        listKota.addAll(getListKota())
        showRecycler()
    }


    private fun getListKota() : ArrayList<Kota>
    {
        val namaKota = ArrayList<String>()
        val imageKota = ArrayList<Int>()
        val deskKota = resources.getStringArray(R.array.description_city)
        namaKota.add("Banda Aceh")
        namaKota.add("Medan")
        namaKota.add("Padang")
        
        imageKota.add(R.drawable.aceh2)
        imageKota.add(R.drawable.medan)
        imageKota.add(R.drawable.padang)


        val getKota = ArrayList<Kota>()
        for (i in namaKota.indices)
        {
            var kota = Kota(namaKota.get(i), imageKota.get(i), deskKota.get(i))
            getKota.add(kota)
        }
        return getKota
    }

    private fun showRecycler()
    {
        rvKota.layoutManager = LinearLayoutManager(this)

//        inisialisasi customAdapter dengan data listKota
        val customAdapter = CustomAdapter(listKota)
        rvKota.adapter = customAdapter
    }
}