package com.example.firstapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstapp.databinding.ActivitySignUpBinding
import java.util.Spliterator

class SignUp : AppCompatActivity() {
    private lateinit var binding:ActivitySignUpBinding
    private lateinit var sp:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.submitBtn.setOnClickListener{
            sp = getSharedPreferences("my_sp", MODE_PRIVATE)

            val name = binding.name.text.toString()
            val age = binding.age.text.toString().toInt()

            val editor = sp.edit()
            editor.apply(){
                putString("sp_name", name)
                putInt("sp_age", age)
                commit()
            }
            startActivity(Intent(this@SignUp, ProfileSetup::class.java))
        }



    }
}