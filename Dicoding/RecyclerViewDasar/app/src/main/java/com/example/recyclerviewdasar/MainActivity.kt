package com.example.recyclerviewdasar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rvHeroes = findViewById(R.id.rv_heroes)
//        Kasih auto ukuran lebar dan tinggi
        rvHeroes.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()
    }

//    dapatin data yang berada pada resources string lalu masukkin ke listHero
    private fun getListHeroes(): ArrayList<Hero> {
        val dataName = resources.getStringArray(R.array.data_nama)
        val dataDescription = resources.getStringArray(R.array.data_deskripsi)
        val dataPhotos = resources.obtainTypedArray(R.array.data_photo)

        val listHero = ArrayList<Hero>()
        for (i in dataName.indices) {
            val hero = Hero(dataName[i], dataDescription[i], dataPhotos.getResourceId(i, -1))
            listHero.add(hero)
        }
        return listHero
    }

//    Tampilin data tersebut ke recycleView
    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes.adapter = listHeroAdapter

    }

//    DIbawah ini hanya opsi untuk menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.action_list -> rvHeroes.layoutManager = LinearLayoutManager(this)
            R.id.action_grid -> rvHeroes.layoutManager = GridLayoutManager(this,2)
        }
        return super.onOptionsItemSelected(item)
    }
}

//  Di MainActivity hanya untuk menampilkan data nya saja. bukan membuat recycleView nya