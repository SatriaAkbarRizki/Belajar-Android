package com.example.explicitintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnMoveActivity: Button
    private lateinit var btnMoveActivityWithData: Button
    private lateinit var btnMoveActivityWithObjek: Button
    private lateinit var btnMoveResult: Button

    /**
     *  val resultLauncher ini digunakan untuk mengambil sebuah nilai dari activity "MoveForResultActivity"
     *  ActivityResultContracts adalah sebuah parameter yang digunakan untuk mengambil nilai kembalian
     *  registerForActivityResult fungsi untuk menerima data kembalian dari activity lain
     */
    private val resultLauncher = registerForActivityResult( ActivityResultContracts.StartActivityForResult())
    { result ->
        if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null) {
            val selectResult =
                result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
            tv_resultNUmber.text = selectResult.toString()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveActivity = btn_MoveActivity1
        btnMoveActivity.setOnClickListener(this)

        btnMoveActivityWithData = btn_MoveActivityData
        btnMoveActivityWithData.setOnClickListener(this)

        btnMoveActivityWithObjek = btn_MoveActivityObjek
        btnMoveActivityWithObjek.setOnClickListener(this)

        btnMoveResult = btn_MoveToResult
        btnMoveResult.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            btnMoveActivity -> {
                startActivity(Intent(this@MainActivity, MainActivity2::class.java))
            }

//            INTENT DGN BAWAK DATA DARI ACTIVITY 1 KE 2
            btnMoveActivityWithData -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)

//              putExtra digunakan untuk menagmbil value dari class MainActivity
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Satria AKbar Rizki")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 18)
                startActivity(moveWithDataIntent)
            }

//            INTENT DGN BAWAK DATA DARI ACTIVITY 1 KE 2
            btnMoveActivityWithObjek -> {
//            Inisialisasi kan data ke objek person
                val person = Person(
                    "Satria AKbar RIzki", 18, "satria@mail.com", "Langsa"
                )
                val moveWithDataObjek = Intent(this@MainActivity, MoveWithObjekActivity::class.java)

//                Mengirim Data objek ke class MoveWithObjekActivity
                moveWithDataObjek.putExtra(MoveWithObjekActivity.EXTRA_PERSON, person)
                startActivity(moveWithDataObjek)
            }

//            INTENT DGN BAWAK DATA DARI ACTIVITY 2
            /**
             *  Perbedaan mendasar antara pakai startActivity dan launch(intent) dari objek resultLauncher
             *  adalah terletak dari nilai kembalian nya, starActivity gak bisa ambil nilai kembalian nya
             *  sedangkan launch(intent) bisa
             */
            btnMoveResult -> {
                val moveWithResultActivity =
                    Intent(this@MainActivity, MoveForResultActivity::class.java)
                resultLauncher.launch(moveWithResultActivity)
            }
        }
    }
}
