package com.example.mogbazarpizzahut

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mogbazarpizzahut.adapter.MenuAdapter
import com.example.mogbazarpizzahut.items.Item

class Menu : AppCompatActivity() {
    private lateinit var menu:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        menu = findViewById(R.id.menu)
        menu.layoutManager =LinearLayoutManager(this)

        val menuList = ArrayList<Item>()

        menuList.add(Item(R.drawable.margherita_pizza, "Margherita Pizza", "Vegetarian",R.string.Margherita_Pizza, R.string.Margherita_Pizza))
        menuList.add(Item(R.drawable.veggie_pizza, "Veggie Pizza", "vegitable",R.string.Margherita_Pizza, R.string.Margherita_Pizza))
        menuList.add(Item(R.drawable.pepperoni_pizza, "Pepperoni Pizza", "Meat",R.string.Margherita_Pizza, R.string.Margherita_Pizza))
        menuList.add(Item(R.drawable.meat_pizza, "Meat Pizza", "Meat",R.string.Margherita_Pizza, R.string.Margherita_Pizza))
        menuList.add(Item(R.drawable.cheese_pizza, "Cheese Pizza", "Meat",R.string.Margherita_Pizza, R.string.Margherita_Pizza))
        menuList.add(Item(R.drawable.bbq_chicken_pizza, "BBQ Chicken Pizza", "Meat",R.string.Margherita_Pizza, R.string.Margherita_Pizza))
        menuList.add(Item(R.drawable.hawaiian_pizza, "Hawaiian Pizza", "Meat",R.string.Margherita_Pizza, R.string.Margherita_Pizza))
        menuList.add(Item(R.drawable.buffalo_pizza, "Buffalo Pizza", "Meat",R.string.Margherita_Pizza, R.string.Margherita_Pizza))
        menuList.add(Item(R.drawable.supreme_pizza, "Supreme Pizza", "Meat",R.string.Margherita_Pizza, R.string.Margherita_Pizza))
        menuList.add(Item(R.drawable.the_works_pizza, "The Works Pizza", "Meat",R.string.Margherita_Pizza, R.string.Margherita_Pizza))

        var adapter = MenuAdapter(menuList)
        menu.adapter = adapter

        adapter.setOnItemClickListener {
            val intent = Intent(this@Menu, ItemDetails::class.java)
            intent.putExtra("itemName", it.itemName)
            intent.putExtra("itemImage", it.itemImage)
            intent.putExtra("itemDetails", it.itemDetails)
            intent.putExtra("itemIngredient", it.itemIngredient)
            startActivity(intent)
        }

    }
}