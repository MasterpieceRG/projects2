package com.example.aadminpanel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.aadminpanel.databinding.ActivityDeleteStudentBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DeleteStudent : AppCompatActivity() {
    private lateinit var binding: ActivityDeleteStudentBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDeleteStudentBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.deleteBtn.setOnClickListener {
            val id = binding.idEt.text.toString()

            if (id.isNotEmpty()) {
                studentData(id)
            }else {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            }
        }

        binding.searchBtn.setOnClickListener {
            val id = binding.idEt.text.toString()
            if (id.isNotEmpty()) {
                searchStudentData(id)
            }else {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun searchStudentData(id: String) {
        database = FirebaseDatabase.getInstance().getReference("Students")
        database.child(id).get().addOnSuccessListener {
            if(it.exists()) {
                binding.studentDataCV.isVisible = true
                binding.nameTv.text = it.child("name").value.toString()
                binding.idTv.text = it.child("id").value.toString()
                binding.emailTv.text = it.child("email").value.toString()
                binding.phoneTv.text = it.child("phone").value.toString()
                binding.subjectTv.text = it.child("subject").value.toString()
                binding.batchTv.text = it.child("batch").value.toString()
            }else {
                Toast.makeText(this, "Student are not exist.", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun studentData(id: String) {
        database = FirebaseDatabase.getInstance().getReference("Students")
        database.child(id).removeValue()
            .addOnSuccessListener {
                Toast.makeText(this, "Student Data Deleted", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@DeleteStudent, MainActivity::class.java))
                finishAffinity()
            }
            .addOnFailureListener {
                Toast.makeText(this@DeleteStudent,"Delete Failed", Toast.LENGTH_SHORT).show()
            }
    }
}