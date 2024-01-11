package com.example.mogbazarpizzahut.signIn_up

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.mogbazarpizzahut.R

class SignUp : AppCompatActivity() {
    private lateinit var signIn: TextView
    private lateinit var registerBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        signIn = findViewById(R.id.signIn)
        registerBtn = findViewById(R.id.registerBtn)

        signIn.setOnClickListener {
            val intent = Intent(this@SignUp, SignIn::class.java)
            startActivity(intent)
        }

        registerBtn.setOnClickListener {
            val intent = Intent(this@SignUp, SignIn::class.java)
            startActivity(intent)
        }
    }
}