package com.example.loginslincing


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.loginslincing.database.LoginDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var emailController: TextView
    private lateinit var passController: TextView
    private lateinit var buttonSignIn: Button
    private lateinit var textSignUp: TextView

    private lateinit var databaseLogin: LoginDatabase

    private fun initView() {
        emailController = findViewById(R.id.editTextEmailAddressLogin)
        passController = findViewById(R.id.editTextPasswordLogin)
        buttonSignIn = findViewById(R.id.button_login)
        textSignUp = findViewById(R.id.textSignUP)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login_activity)
        initView()

    }

    override fun onStart() {
        databaseLogin = LoginDatabase(this)
        loginUser()
        textSignUp.setOnClickListener {
            val pushSignUp = Intent(this, SignUpActivity::class.java)
            startActivity(pushSignUp)
        }
        super.onStart()
    }
    private fun loginUser() {
        val dataLogin = databaseLogin.readDataLogin()
        buttonSignIn.setOnClickListener {
            if (emailController.text.isNotEmpty() && passController.text.isNotEmpty()) {
                dataLogin.forEach { loginModel ->
                    if (loginModel.Email == emailController.text.toString() && loginModel.Password == passController.text.toString()) {
                        Log.i("Login Status", "Login successful for ${loginModel.Email} and ${loginModel.Password}")
                        val navPushHome = Intent(this, HomeActivty::class.java)
                        navPushHome.putExtra("ListUser", ArrayList(dataLogin))
                        startActivity(navPushHome)
                        finish()

                    }else{
                        Log.e("Error Login", "Login Not Succes")
                    }
                }
            }
        }
    }

}