package com.example.mymovienote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mymovienote.databinding.ActivityGetStartPageBinding

class GetStartPage : AppCompatActivity() {
    private lateinit var binding: ActivityGetStartPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityGetStartPageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.getStartBtn.setOnClickListener {
            startActivity(Intent(this@GetStartPage, SignInPage::class.java))
            finishAffinity()
        }
    }
}