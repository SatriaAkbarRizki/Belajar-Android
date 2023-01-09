package com.example.recyclerviewdasar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.recyclerviewdasar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val namaKota = ArrayList<String>()
    private lateinit var customAdapter: CustomAdapter

    companion object{
        lateinit var binding : ActivityMainBinding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        customAdapter = CustomAdapter(namaKota)
        val layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = customAdapter
        binding.recyclerView.setHasFixedSize(true)
        itemList()
    }

    fun itemList()
    {
        namaKota.add("Banda Aceh")
        namaKota.add("Medan")
        namaKota.add("Padang")
        customAdapter.notifyDataSetChanged()

    }
}

