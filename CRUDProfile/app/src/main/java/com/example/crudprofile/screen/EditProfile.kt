package com.example.crudprofile.screen

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContentProviderCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.crudprofile.MainActivity
import com.example.crudprofile.R
import com.example.crudprofile.model.PeopleModel
import com.example.crudprofile.service.ProfileNetwork
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class EditProfile : AppCompatActivity() {
    private lateinit var tvEditNameProfiles: TextView
    private lateinit var tvEditAddressProfiles: TextView
    private lateinit var btnUpdateProfile: Button
    private lateinit var profile: ProfileNetwork
    private lateinit var idData: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_profile)
        initView()
        profile = ProfileNetwork()
        retreiveIntentExtra()
    }

    override fun onResume() {
        updateProfileUser()
        super.onResume()
    }

    private fun initView() {

        tvEditNameProfiles = findViewById(R.id.tvedit_nameprofiles)
        tvEditAddressProfiles = findViewById(R.id.tvedit_addressprofiles)
        btnUpdateProfile = findViewById(R.id.btn_updateprofile)
    }

    private fun retreiveIntentExtra() {
        val results = intent.getParcelableExtra<PeopleModel>("extraEditProfile")
        if (results != null) {
            idData = results.id
        }
        tvEditNameProfiles.text = results?.name ?: "No have Name"
        tvEditAddressProfiles.text = results?.address ?: "No Have Address"
    }


    private fun updateProfileUser() {
        btnUpdateProfile.setOnClickListener {
            if (tvEditNameProfiles.text.isNotEmpty() && tvEditAddressProfiles.text.isNotEmpty()) {
                lifecycleScope.launch {
                    try {
                        val response = profile.updateProfile(
                            PeopleModel(
                                id = idData,
                                name = tvEditNameProfiles.text.toString(),
                                address = tvEditAddressProfiles.text.toString(),
                                avatar = "NoFound"
                            )
                        )

                        if (response == true) {
                            var toasts = Toast.makeText(
                                this@EditProfile,
                                "Succes Update Profile",
                                Toast.LENGTH_LONG
                            )
                            toasts.show()
                            delay(1500L)

                            val navPushBack = Intent(this@EditProfile, MainActivity::class.java)
                            startActivity(navPushBack)
                            ActivityCompat.finishAffinity(this@EditProfile)


                        }
                        Log.i("Status Update", response.toString())

                    } catch (e: Exception) {
                        Log.e("Error Update Profile", e.message ?: "Unknown Error")
                    }
                }
            }
        }
    }
}