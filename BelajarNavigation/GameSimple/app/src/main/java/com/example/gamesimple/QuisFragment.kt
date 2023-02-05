package com.example.gamesimple

import android.app.Activity
import android.os.Bundle
import android.service.quickaccesswallet.QuickAccessWalletService
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.findFragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.gamesimple.databinding.FragmentQuisBinding

class QuisFragment : Fragment() {

    var score_apple = 0
    var score_android = 0
    var current_quizText = 0

    val quizDecription = arrayOf(
        "",
        "Sistem apa yang kamu pakai saat ini?",
        "Sistem Mana yang kamu sukai untuk urusan Performa",
        "Sistem Mana yang kamu sukai untuk urusan kustomisasi?"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity).supportActionBar?.title = "Quis"

        val binding: FragmentQuisBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_quis, container, false
        )

        binding.btnApple.setOnClickListener {
            score_apple++
            nextQuestion(binding)
        }

        binding.btnAndroid.setOnClickListener {
            score_android++
            nextQuestion(binding)
        }

        return binding.root
    }


//    Ambil isi dari bindingg untuk diproses pengecekan question
    fun nextQuestion(binding: FragmentQuisBinding) {
        current_quizText++

        if (current_quizText < quizDecription.size) {
            binding.tvQuizText.text = quizDecription[current_quizText]
            Toast.makeText(
                context,
                "Berhasil, Score Apple: " + score_apple + " & Score Android: " + score_android,
                Toast.LENGTH_LONG
            )
                .show()
        } else {

            var resultTextFinish: String = ""
            var resultImage : Int? = null
            var listresultImage = listOf <Int>(R.drawable.apple_finish_gif, R.drawable.android_finish_gif)

            if (score_apple >= score_android)
            {
                resultTextFinish = "Selamat Kamu adalah Pengguna Iphone"
                resultImage = listresultImage.get(0)
            }
            else{
                resultTextFinish = "Selamat Kamu adalah Pengguna Android"
                resultImage = listresultImage.get(1)
            }
            view?.findNavController()?.navigate(QuisFragmentDirections.actionFrQuisFragmentToFinishQuizFragment(resultTextFinish,resultImage
            ))
        }

    }
}