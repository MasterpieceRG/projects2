package com.example.aadminpanel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aadminpanel.databinding.ActivityUpdateStudentBinding

class UpdateStudent : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateStudentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityUpdateStudentBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)




    }
}