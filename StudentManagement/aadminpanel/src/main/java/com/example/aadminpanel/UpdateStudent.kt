package com.example.aadminpanel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.aadminpanel.databinding.ActivityUpdateStudentBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UpdateStudent : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateStudentBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityUpdateStudentBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.searchBtn.setOnClickListener {
            val id = binding.idSearchEt.text.toString()
            if (id.isNotEmpty()) {
                searchStudentData(id)
            }else {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            }
        }

        binding.updateBtn.setOnClickListener {
            val name = binding.nameEt.text.toString()
            val id = binding.idEt.text.toString()
            val email = binding.emailEt.text.toString()
            val phone = binding.phoneEt.text.toString()
            val subject = binding.subjectEt.text.toString()
            val batch = binding.batchEt.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Students")
            val student = mapOf(
                "name" to name,
                "id" to id,
                "email" to email,
                "phone" to phone,
                "subject" to subject,
                "batch" to batch)
            database.child(id).updateChildren(student)
                .addOnSuccessListener {
                    Toast.makeText(this, "Student Data Updated", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@UpdateStudent, MainActivity::class.java))
                    finishAffinity()
                }
                .addOnFailureListener {
                    Toast.makeText(this@UpdateStudent,"Update Failed", Toast.LENGTH_SHORT).show()
                }
        }


    }

    private fun searchStudentData(id: String) {
        database = FirebaseDatabase.getInstance().getReference("Students")
        database.child(id).get().addOnSuccessListener {
            if(it.exists()) {
                binding.nameEt.setText(it.child("name").value.toString())
                binding.idEt.setText(it.child("id").value.toString())
                binding.emailEt.setText(it.child("email").value.toString())
                binding.phoneEt.setText(it.child("phone").value.toString())
                binding.subjectEt.setText(it.child("subject").value.toString())
                binding.batchEt.setText(it.child("batch").value.toString())
            }else {
                Toast.makeText(this, "Student are not exist.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}