package com.example.sharedpreference

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sp:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.saveBtn.setOnClickListener{
            startActivity(
                Intent(
                    this,RegisterPage::class.java
                )
            )
            sp = getSharedPreferences("my_sp", MODE_PRIVATE)
            val name = binding.nameEt.text.toString()
            val age = binding.ageEt.text.toString().toInt()
            val editor = sp.edit()

            editor.apply{
                putString("sp_name", name)
                putInt("sp_age", age)
                commit()
            }

         }

    }
}