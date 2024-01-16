package com.example.aadminpanel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.aadminpanel.databinding.ActivityAddStudentBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddStudent : AppCompatActivity() {
    private lateinit var binding: ActivityAddStudentBinding
    private lateinit var database:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddStudentBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.saveBtn.setOnClickListener {
            val name = binding.nameEt.text.toString()
            val id = binding.idEt.text.toString()
            val email = binding.emailEt.text.toString()
            val phone = binding.phoneEt.text.toString()
            val subject = binding.subjectEt.text.toString()
            val batch = binding.batchEt.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Students")
            val student = StudentData(name, id, email, phone, subject, batch)
            database.child(id.toString()).setValue(student)
                .addOnSuccessListener {
                    Toast.makeText(this, "Student Data Added", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@AddStudent, MainActivity::class.java))
                    finishAffinity()
                }
                .addOnFailureListener {
                    Toast.makeText(this@AddStudent,"Added Failed",Toast.LENGTH_SHORT).show()
                }
        }
    }
}