package com.example.studentmanagement

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private var studentList: List<Items>): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val position = studentList[position]
        holder.name.text = position.name
        holder.id.text = position.id

        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                it(position)
            }
        }
    }
}

class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
    var name: TextView = view.findViewById(R.id.name)
    var id: TextView = view.findViewById(R.id.id)
}

private var onItemClickListener: ((Items) -> Unit)? = null

fun setOnItemClickListener(listener : ((Items) -> Unit)) {
    onItemClickListener = listener
}