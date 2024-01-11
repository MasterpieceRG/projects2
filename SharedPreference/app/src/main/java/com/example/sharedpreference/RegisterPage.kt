package com.example.sharedpreference

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreference.databinding.ActivityMainBinding

class RegisterPage : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sp: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        sp = getSharedPreferences("my_sp", MODE_PRIVATE)
        setContentView(binding.root)



        val name = sp.getString("sp_name",null)
        val age = sp.getInt("sp_age", 0)


        if(age != 0) {
            binding.ageEt.setText(age.toString())
        }
    }
}