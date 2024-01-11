package org.freedu.customlistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.simple_playerlist.R
import de.hdodenhof.circleimageview.CircleImageView

class PlayerAdapter(context:Context, playerList:ArrayList<Player>):ArrayAdapter<Player>(context, 0, playerList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItemView = convertView
        if(listItemView == null){
            listItemView = LayoutInflater.from(context).inflate(R.layout.activity_player_item, parent, false)
        }

        val playerImage = listItemView!!.findViewById<CircleImageView>(R.id.profile_image)
        val playerName = listItemView!!.findViewById<TextView>(R.id.playerName)
        val playerDeatils = listItemView!!.findViewById<TextView>(R.id.playerDetails)

        playerName.setText(getItem(position)!!.playerName)
        playerDeatils.setText(getItem(position)!!.playerDetails)
        playerImage.setImageResource(getItem(position)!!.playerImage)


        return listItemView
    }
}