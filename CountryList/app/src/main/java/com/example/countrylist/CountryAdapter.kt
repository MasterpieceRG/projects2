package com.example.countrylist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class CountryAdapter(context:Context,
    countryList:ArrayList<Country>
    ):ArrayAdapter<Country>
    (context, 0, countryList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if(itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        }
        val countryImage = itemView!!.findViewById<CircleImageView>(R.id.image)
        val countryName = itemView.findViewById<TextView>(R.id.name)
        val countryDetails = itemView.findViewById<TextView>(R.id.details)

        countryImage.setImageResource(getItem(position)!!.image)
        countryName.setText(getItem(position)!!.name)
        countryDetails.setText(getItem(position)!!.details)

        return itemView
    }
}