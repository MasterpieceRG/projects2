package com.example.mogbazarpizzahut.signIn_up

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.mogbazarpizzahut.Menu
import com.example.mogbazarpizzahut.R

class SignIn : AppCompatActivity() {
    private lateinit var signUp: TextView
    private lateinit var signinBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        signUp = findViewById(R.id.signUp)
        signinBtn = findViewById(R.id.signInBtn)

        signUp.setOnClickListener {
            val intent = Intent(this@SignIn, SignUp::class.java)
            startActivity(intent)
        }

        signinBtn.setOnClickListener {
            val intent = Intent(this@SignIn, Menu::class.java)
            startActivity(intent)
        }
    }
}