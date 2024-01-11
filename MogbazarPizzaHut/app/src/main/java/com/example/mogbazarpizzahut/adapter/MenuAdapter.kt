package com.example.mogbazarpizzahut.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mogbazarpizzahut.R
import com.example.mogbazarpizzahut.items.Item
import de.hdodenhof.circleimageview.CircleImageView

class MenuAdapter(private val menuList:List<Item>) : RecyclerView.Adapter<MenuAdapter.MyViewHolder>() {

    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        val name = view.findViewById<TextView>(R.id.itemName)
        val type = view.findViewById<TextView>(R.id.itemType)
        val image = view.findViewById<CircleImageView>(R.id.itemImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listPosition =menuList[position]
        holder.image.setImageResource(listPosition.itemImage)
        holder.name.text = listPosition.itemName
        holder.type.text = listPosition.itemType

        holder.itemView.setOnClickListener{
            onItemClickListener?.let {
                it(listPosition)
            }
        }
    }

    private var onItemClickListener: ((Item)->Unit)? = null
    fun setOnItemClickListener(listener: ((Item)->Unit)) {
        onItemClickListener = listener
    }
}
