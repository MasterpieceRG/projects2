package com.example.studentmanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studentmanagement.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val sList = binding.studentList
        sList.layoutManager = GridLayoutManager(this, 2)
        database = FirebaseDatabase.getInstance().getReference("Students")

        val studentList = ArrayList<Items>()




        studentList.add((Items("Rabbi","0210", "rabbi@gmail.com","01303610320","Kotlin","02")))
        studentList.add((Items("Fahim","0203", "rabbi@gmail.com","01303610320","Kotlin","02")))
        studentList.add((Items("Rabbi","0210", "rabbi@gmail.com","01303610320","Kotlin","02")))
        studentList.add((Items("Fahim","0203", "rabbi@gmail.com","01303610320","Kotlin","02")))
        studentList.add((Items("Rabbi","0210", "rabbi@gmail.com","01303610320","Kotlin","02")))
        studentList.add((Items("Fahim","0203", "rabbi@gmail.com","01303610320","Kotlin","02")))
        studentList.add((Items("Rabbi","0210", "rabbi@gmail.com","01303610320","Kotlin","02")))
        studentList.add((Items("Fahim","0203", "rabbi@gmail.com","01303610320","Kotlin","02")))
        studentList.add((Items("Rabbi","0210", "rabbi@gmail.com","01303610320","Kotlin","02")))
        studentList.add((Items("Fahim","0203", "rabbi@gmail.com","01303610320","Kotlin","02")))
        studentList.add((Items("Rabbi","0210", "rabbi@gmail.com","01303610320","Kotlin","02")))
        studentList.add((Items("Fahim","0203", "rabbi@gmail.com","01303610320","Kotlin","02")))
        studentList.add((Items("Rabbi","0210", "rabbi@gmail.com","01303610320","Kotlin","02")))
        studentList.add((Items("Fahim","0203", "rabbi@gmail.com","01303610320","Kotlin","02")))
        studentList.add((Items("Rabbi","0210", "rabbi@gmail.com","01303610320","Kotlin","02")))
        studentList.add((Items("Fahim","0203", "rabbi@gmail.com","01303610320","Kotlin","02")))
        studentList.add((Items("Rabbi","0210", "rabbi@gmail.com","01303610320","Kotlin","02")))
        studentList.add((Items("Fahim","0203", "rabbi@gmail.com","01303610320","Kotlin","02")))





        val sAdapter = StudentAdapter(studentList)
        sList.adapter = sAdapter


    }
}