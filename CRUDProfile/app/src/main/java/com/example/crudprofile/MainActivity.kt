package com.example.crudprofile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ListView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.crudprofile.adapter.ListAdapter
import com.example.crudprofile.model.PeopleModel
import com.example.crudprofile.screen.DetailProfile
import com.example.crudprofile.service.ProfileNetwork
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var profile: ProfileNetwork
    private var resultsProfile = mutableListOf<PeopleModel>()
    private lateinit var adapterList : ListAdapter
    private lateinit var listView : ListView
    private lateinit var progressBar : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        profile = ProfileNetwork()
        initView()

        lifecycleScope.launch {
            try {
                progressBar.visibility = View.VISIBLE
                listView.visibility = View.GONE

                resultsProfile.addAll(profile.getProfile())
                resultsProfile.forEach {
                    Log.i("Success", "Got ${it.toString()}")
                }
                adapterList.notifyDataSetChanged()

                progressBar.visibility = View.GONE
                listView.visibility = View.VISIBLE

            } catch (e: Exception) {
                Log.e("Error", e.message ?: "Unknown error")
            }
        }

        onClickItemProfile()

    }

    private fun initView(){
        Log.i("Success2", "Got ${resultsProfile.size} profiles")
        listView = findViewById(R.id.listPPeople)
        adapterList = ListAdapter(this, resultsProfile)
        listView.adapter = adapterList
        progressBar = findViewById(R.id.progressBar)
    }

    private fun onClickItemProfile(){
        listView.setOnItemClickListener { parent, view, position, id ->
            val itemClick = resultsProfile[position]
//            Log.i("Item On Click", itemClick.toString())
            val navPushDetail = Intent(this, DetailProfile::class.java)
            navPushDetail.putExtra("ValueDetailProfile", itemClick)
            startActivity(navPushDetail)

        }
    }
}

