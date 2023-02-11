package com.example.gamesimple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.gamesimple.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//    private lateinit var drawerLayout: DrawerLayout Code untuk menu drawer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

//        drawerLayout = binding.drawerlayout

//         NavController dan method onSupportNavigateUp
//         berfungsi untuk agar ada button untuk kembali setaip frame
        val navController = this.findNavController(R.id.navHost_fragment)
//        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

//        NavigationUI.setupWithNavController(binding.navMenuView, navController)   Code untuk menu drawer


        NavigationUI.setupWithNavController(binding.bottomNav, navController)

        AppCompatDelegate.setDefaultNightMode(
            AppCompatDelegate.MODE_NIGHT_NO
        )

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.navHost_fragment)
        return navController.navigateUp()
    }
}