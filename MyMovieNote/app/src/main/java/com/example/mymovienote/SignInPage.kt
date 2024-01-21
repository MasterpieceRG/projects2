package com.example.mymovienote

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mymovienote.databinding.ActivitySignInPageBinding
import com.google.firebase.auth.FirebaseAuth

class SignInPage : AppCompatActivity() {
    private lateinit var binding: ActivitySignInPageBinding
    private lateinit var sp:SharedPreferences
    private lateinit var epAuth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignInPageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        epAuth = FirebaseAuth.getInstance()
        val name = intent.getStringExtra("name")

        binding.signinBtn.setOnClickListener {
            val intent = Intent(this@SignInPage, HomePage::class.java)
            val email = binding.emailEt.text.toString()
            val pass = binding.passEt.text.toString()

            if(email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Please fill the all fields", Toast.LENGTH_SHORT).show()
            }else {
                epAuth.signInWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(this) {
                        if(it.isSuccessful) {
                            intent.putExtra("name", name)
                            startActivity(intent)
                            finish()
                        }else{
                            Toast.makeText(this, "Account Not Found", Toast.LENGTH_SHORT).show()
                        }
                        Toast.makeText(this, "Sign in Successful", Toast.LENGTH_SHORT).show()
                    }
            }
        }

        binding.goSignup.setOnClickListener {
            startActivity(Intent(this@SignInPage, SignUpPage::class.java))
        }

    }
}