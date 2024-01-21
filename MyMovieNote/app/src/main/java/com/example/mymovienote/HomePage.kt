package com.example.mymovienote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mymovienote.databinding.ActivityHomePageBinding

class HomePage : AppCompatActivity() {
    private lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.nameTv.setText(intent.getStringExtra("name"))


    }
}