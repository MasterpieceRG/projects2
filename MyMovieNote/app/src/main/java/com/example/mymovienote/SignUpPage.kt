package com.example.mymovienote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mymovienote.databinding.ActivitySignUpPageBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class SignUpPage : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignUpPageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.signupBtn.setOnClickListener {
            val name = binding.nameEt.text.toString()
            val email = binding.emailEt.text.toString()
            val pass = binding.passEt.text.toString()
            val conPass = binding.conpassEt.text.toString()

            if(name.isEmpty() || email.isEmpty() || pass.isEmpty() || conPass.isEmpty()) {
                Toast.makeText(this, "Please fill the all fields", Toast.LENGTH_SHORT).show()
            }else if(pass != conPass) {
                Toast.makeText(this, "Password and Confirm password should be same", Toast.LENGTH_SHORT).show()
            }else if(pass.length < 8) {
                Toast.makeText(this, "Password should be at least 8 characters long", Toast.LENGTH_SHORT).show()
            }else {
                Firebase.auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this@SignUpPage, SignInPage::class.java)
                        intent.putExtra("name", name)
                        startActivity(intent)
                        finish()
                    }else {
                        Toast.makeText(this, it.exception?.localizedMessage, Toast.LENGTH_SHORT).show()
                    }
                    Toast.makeText(this, "Sign up Successful", Toast.LENGTH_SHORT).show()
                }
            }

            binding.goSignin.setOnClickListener {
                startActivity(Intent(this@SignUpPage, SignInPage::class.java))
            }
        }
    }
}