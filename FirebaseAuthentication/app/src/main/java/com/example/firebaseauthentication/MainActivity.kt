package com.example.firebaseauthentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebaseauthentication.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.registerBtn.setOnClickListener {
            if(binding.emailEt.text.toString().isEmpty() || binding.passwordEt.text.toString().isEmpty() || binding.conPassEt.text.toString().isEmpty()) {
                Toast.makeText(this, "Please fill the fields", Toast.LENGTH_SHORT).show()
            }else if(binding.passwordEt.text.toString() != binding.conPassEt.text.toString()) {
                Toast.makeText(this, "Password and confirm password should be same", Toast.LENGTH_SHORT).show()
            }else if(binding.passwordEt.text.toString().length < 8) {
                Toast.makeText(this, "Password should be at least 8 characters long", Toast.LENGTH_SHORT).show()
            }else {
                Firebase.auth.createUserWithEmailAndPassword(binding.emailEt.text.toString(), binding.passwordEt.text.toString())
                    .addOnCompleteListener {
                        if(it.isSuccessful){
                            startActivity(Intent(this@MainActivity, SignIn::class.java))
                            finish()
                        }else {
                            Toast.makeText(this, it.exception?.localizedMessage, Toast.LENGTH_SHORT).show()
                        }
                        Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
                    }
            }
        }

        binding.goSignIn.setOnClickListener {
            startActivity(Intent(this@MainActivity, SignIn::class.java))
        }
    }
}