package com.example.explicitintent

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_move_for_result.*

class MoveForResultActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_select_value"
        const val RESULT_CODE = 110
    }

    private lateinit var btnChoose: Button
    private lateinit var rgNumber: RadioGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_for_result)

        btnChoose = btn_choose
        rgNumber = rg_number
        btnChoose.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (rgNumber.checkedRadioButtonId > 0) {
            var value = 0

            /**
             *  kayaknya kita harus mengambil radioButton dengn pakai ID deh
             *  kalau langsung kita panggil gak bisa di inisialisasi
             */
            when (rgNumber.checkedRadioButtonId) {
                R.id.rb_100 -> value = 100
                R.id.rb_240 -> value = 240
                R.id.rb_300 -> value = 300
                R.id.rb_310 -> value = 310
            }

            /**
             *  Kode dibawah ini, kita tidak pakai intent untuk input namun kita gunakan untuk memasukkan sebuah nilai
             *  putExtradibawah  berfungsi untuk memasukkan sebuah nilai dari key dan value
             *  lalu disimpan di method setResult
             */
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
            setResult(RESULT_CODE, resultIntent)
            finish()
        }
    }
}