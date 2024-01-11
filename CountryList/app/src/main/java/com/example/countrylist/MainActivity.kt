package com.example.countrylist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private lateinit var countrys:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countrys = findViewById(R.id.countrys)

        val countryList:ArrayList<Country> = ArrayList<Country>()

        countryList.add(Country(R.color.black, "Pakistan", "Islamic Republic of Pakistan"))


        val countryAdapter = CountryAdapter(this,countryList)

        countrys.adapter = countryAdapter
    }
}