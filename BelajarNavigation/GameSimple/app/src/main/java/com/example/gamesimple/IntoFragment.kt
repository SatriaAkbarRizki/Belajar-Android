package com.example.gamesimple

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.os.Bundle
import android.transition.Transition
import android.transition.TransitionInflater
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.gamesimple.databinding.FragmentIntoBinding
import android.view.Window as Window

class IntoFragment : Fragment() {
    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        Kalau pakai fragment, begini cara kita ubah title di actionbar nya
        (activity as AppCompatActivity).supportActionBar?.title = "Game Pilihan Android dan IOS"

//        set semua view ke dalam binding
        val binding : FragmentIntoBinding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_into, container, false)


        binding.btnStar.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.fr_quisFragment)
        )

        setHasOptionsMenu(true)
        return binding.root


    }

//    Dua fungsi ini berfungsi untuk membuat menu dan disarankan nama id menu sama dengan nama id layout ABoutFragment
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater.inflate(R.menu.about_app, menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
//                || (super.onOptionsItemSelected(item))
//    }
}

//  Biasanya kan kita kalau mau pindah activity harus ada intent kan??
//  Tapi kalo ini tidak, tinggal pakai binding aja, karena udah kita terapkan navigation