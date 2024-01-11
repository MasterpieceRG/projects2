package com.example.menubar

import android.content.Context
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast

class CustomMenu {

    fun customMenu(context: Context, view: View){
        val pop = PopupMenu(context, view)
        pop.inflate(R.menu.menu_item)

        pop.setOnMenuItemClickListener {
            when(it!!.itemId){
                R.id.profile -> {
                    Toast.makeText(context, "Profile", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.setting -> {
                    Toast.makeText(context, "Settings", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.logout -> {
                    Toast.makeText(context, "Logout", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
        try {
            val fieldMenupopup = PopupMenu::class.java.getDeclaredField("mPopup")
            fieldMenupopup.isAccessible = true
            val mPopup = fieldMenupopup.get(pop)
            mPopup.javaClass
                .getDeclaredMethod("setFoeceShowIcon", Boolean::class.java)
                .invoke(mPopup, true)

        }catch (e:Exception){

        }finally {
            pop.show()
        }
    }
}