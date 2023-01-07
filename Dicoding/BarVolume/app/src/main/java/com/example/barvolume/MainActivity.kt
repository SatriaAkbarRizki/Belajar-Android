package com.example.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.View
import android.widget.EditText
import com.example.barvolume.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityMainBinding

//    Tambahkan STATE_RESULT, onSaveInstanceState, dan savedInstanceState
//    yang dimana ketika sebuah activity ubah ke mode potrait atau landscape, nilai nya tetap ada

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tv_result.text.toString())
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//            Kita pakai setOnClickListener agar  method onClick bisa memakai sebuah objek dari onCreate
        binding.btnHasilPenjumlahan.setOnClickListener(this)

        if (savedInstanceState != null) {
            val resultBack = savedInstanceState.getString(STATE_RESULT)
            binding.tvResult.setText(resultBack)
        }
    }

    override fun onClick(v: View?) {
        val inputPanjang = binding.edtInputPanjang.text.toString().trim()
        val inputLebar = binding.edtInputLebar.text.toString().trim()
        val inputTinggi = binding.edtInputTinggi.text.toString().trim()

        var isEmptyFields: Boolean = false

        if (inputPanjang.isEmpty()) {
            isEmptyFields = true
            binding.edtInputPanjang.error = "Mohon Masukkan Angka nya"
        }

        if (inputLebar.isEmpty()) {
            isEmptyFields = true
            binding.edtInputLebar.error = "Mohon Masukkan Angka nya"
        }

        if (inputTinggi.isEmpty()) {
            isEmptyFields = true
            binding.edtInputTinggi.error = "Mohon Masukkan Angka nya"
        }

        if (!isEmptyFields) {
            val volume = inputPanjang.toDouble() + inputLebar.toDouble() + inputPanjang.toDouble()
            binding.tvResult.setText(volume.toString())
        }
    }
}