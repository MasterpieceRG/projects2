package com.example.allcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.allcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var actionBarDrawerTaggle:ActionBarDrawerToggle
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var navConlloer = findNavController(R.id.fragmentContainerView)
        binding.bottonBar.setupWithNavController(navConlloer)

        actionBarDrawerTaggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.nav_open, R.string.nav_close);
        actionBarDrawerTaggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.draweNav.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.bmiFragment -> {
                    binding.drawerLayout.closeDrawers()
                    binding.draweNav.setupWithNavController(navConlloer)
                }
                R.id.unitFragment ->{
                    binding.drawerLayout.closeDrawers()
                    binding.draweNav.setupWithNavController(navConlloer)
                }
                R.id.ageFragment ->{
                    binding.drawerLayout.closeDrawers()
                    binding.draweNav.setupWithNavController(navConlloer)
                }
                R.id.themeFragment ->{
                    binding.drawerLayout.closeDrawers()
                    binding.draweNav.setupWithNavController(navConlloer)
                }
                R.id.fontFragment ->{
                    binding.drawerLayout.closeDrawers()
                    binding.draweNav.setupWithNavController(navConlloer)
                }
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if(actionBarDrawerTaggle.onOptionsItemSelected(item)){
            true
        }
        else super.onOptionsItemSelected(item)
    }
}


