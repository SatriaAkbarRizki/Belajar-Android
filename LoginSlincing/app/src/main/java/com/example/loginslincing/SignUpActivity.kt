package com.example.loginslincing

import android.location.Address
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginslincing.database.LoginDatabase
import com.example.loginslincing.model.LoginModel

class SignUpActivity : AppCompatActivity() {
    lateinit var emailController: TextView
    lateinit var passController: TextView
    lateinit var addressController: TextView
    lateinit var buttonSignUp: Button

    private lateinit var databaseLogin: LoginDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_activity)
        initView()
    }

    override fun onStart() {
        databaseLogin = LoginDatabase(this)
        buttonClick()
        super.onStart()
    }

    fun initView() {
        emailController = findViewById(R.id.editTextEmailSignUp)
        passController = findViewById(R.id.editTextTextPasswordSignUp)
        addressController = findViewById(R.id.editTextTextAndressSignUp)
        buttonSignUp = findViewById(R.id.button_signup)
    }

    fun buttonClick() {
        buttonSignUp.setOnClickListener {
            if (emailController.text.isNotEmpty() && passController.text.isNotEmpty()) {
                databaseLogin.insertSignUp(
                    LoginModel(
                        0,
                        emailController.text.toString(),   // Convert to String
                        passController.text.toString(),    // Convert to String
                        addressController.text.takeIf { it.isNotEmpty() }.toString()
                            ?: " "  // Convert to String if not null
                    )
                )
                val data = databaseLogin.readDataLogin()
                Log.i("Value", data.toString())
            }
        }
    }

}