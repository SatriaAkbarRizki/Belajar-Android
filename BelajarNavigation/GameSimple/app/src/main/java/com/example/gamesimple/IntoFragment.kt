package com.example.gamesimple

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.gamesimple.databinding.FragmentIntoBinding

class IntoFragment : Fragment() {
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
        return binding.root


    }
}

//  Biasanya kan kita kalau mau pindah activity harus ada intent kan??
//  Tapi kalo ini tidak, tinggal pakai binding aja, karena udah kita terapkan navigation