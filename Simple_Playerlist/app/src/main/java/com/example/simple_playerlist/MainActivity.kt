package org.freedu.customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.simple_playerlist.R

class MainActivity : AppCompatActivity() {
    private lateinit var listView:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        listView = findViewById(R.id.listView)

        val playerList:ArrayList<Player> = ArrayList<Player>()

        playerList.add(Player(R.color.black, "Lionel Messi", "Argentine footballer"))
        playerList.add(Player(R.color.white, "Lionel Messi", "Argentine footballer"))
        playerList.add(Player(R.color.black, "Lionel Messi", "Argentine footballer"))
        playerList.add(Player(R.color.white, "Lionel Messi", "Argentine footballer"))
        playerList.add(Player(R.color.black, "Lionel Messi", "Argentine footballer"))
        playerList.add(Player(R.color.black, "Lionel Messi", "Argentine footballer"))
        playerList.add(Player(R.color.black, "Lionel Messi", "Argentine footballer"))
        playerList.add(Player(R.color.black, "Lionel Messi", "Argentine footballer"))


        val playerAdapter = PlayerAdapter(this, playerList)

        listView.adapter = playerAdapter

    }
}