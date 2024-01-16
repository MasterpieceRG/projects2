package com.example.aadminpanel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aadminpanel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.addBtn.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddStudent::class.java))
            finish()
        }
        binding.updateBtn.setOnClickListener {
            startActivity(Intent(this@MainActivity, UpdateStudent::class.java))
            finish()
        }
        binding.deleteBtn.setOnClickListener {
            startActivity(Intent(this@MainActivity, DeleteStudent::class.java))
            finish()
        }
    }
}