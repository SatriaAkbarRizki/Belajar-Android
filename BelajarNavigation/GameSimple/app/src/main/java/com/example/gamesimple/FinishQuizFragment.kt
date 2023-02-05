package com.example.gamesimple

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.gamesimple.databinding.FragmentFinishQuizBinding

class FinishQuizFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity).supportActionBar?.title = "Selesai"

        val binding: FragmentFinishQuizBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_finish_quiz, container, false
        )


//        Mengambil data dari Fragment Quis, dengan menggunakan argument
        var args = FinishQuizFragmentArgs.fromBundle(requireArguments())
        binding.tvFinish.text = args.result

        Glide.with(this)
            .load(args.image)
            .into(binding.gifImageView)

        return binding.root
    }


}

//  Disini kita akan passing data dari fragment quiz ke fragment finish
//  Kalau lupa depedency nya, liat document gugel tentang pass data

//  Kalau pengen ingin kembali ke awal, tinggal atur PopUpTur di Pop Behavior