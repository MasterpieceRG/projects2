package com.example.sharedpreference

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreference.databinding.ActivityMain2Binding
import kotlin.system.exitProcess

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var sp:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        sp = getSharedPreferences("my_sp", MODE_PRIVATE)
        val email = sp.getString("email", null)
        val pass = sp.getString("pass", null)

        binding.email.setText(email)
        binding.pass.setText(pass)

    }
}