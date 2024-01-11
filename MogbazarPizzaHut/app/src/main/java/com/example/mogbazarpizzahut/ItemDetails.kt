package com.example.mogbazarpizzahut

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.example.mogbazarpizzahut.signIn_up.SignIn
import de.hdodenhof.circleimageview.CircleImageView

class ItemDetails : AppCompatActivity() {
    private lateinit var itemImage:ImageView
    private lateinit var itemName:TextView
    private lateinit var itemIngredient:TextView
    private lateinit var itemDetails:TextView
    private lateinit var backBtn: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_details)

        itemImage = findViewById(R.id.itemImage)
        itemName = findViewById(R.id.itemName)
        itemIngredient = findViewById(R.id.itemIngredient)
        itemDetails = findViewById(R.id.itemDetails)
        backBtn = findViewById(R.id.backBtn)

        itemImage.setImageResource(intent.getIntExtra("itemImage", 0))
        itemName.text = intent.getStringExtra("itemName")
        itemIngredient.setText(intent.getIntExtra("itemIngredient", 0))
        itemDetails.setText(intent.getIntExtra("itemDetails", 0))


        backBtn.setOnClickListener {
            val intent = Intent(this@ItemDetails, Menu::class.java)
            startActivity(intent)
        }


    }
}