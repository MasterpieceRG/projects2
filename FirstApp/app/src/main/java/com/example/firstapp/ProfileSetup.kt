package com.example.firstapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstapp.databinding.ActivityProfileSetupBinding

class ProfileSetup : AppCompatActivity() {
    private lateinit var binding: ActivityProfileSetupBinding
    private lateinit var sp:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileSetupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sp = getSharedPreferences("my_sp", MODE_PRIVATE)

        val name = sp.getString("sp_name", null)
        val age = sp.getInt("sp_age", 0)

        binding.name.setText(name)
        if (age != 0) {
            binding.age.setText(age.toString())
        }
    }
}