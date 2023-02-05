package com.lahbouch.navigation_menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarMenu
import com.google.android.material.navigation.NavigationBarView
import kotlin.math.log

class MainActivity : AppCompatActivity() {


    lateinit var menu : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        menu  = findViewById(R.id.menu)

        menu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> setFragment(FragmentHome())
                R.id.contact -> setFragment(FragmentContact())
                R.id.news -> setFragment(FragementNews())
                else -> setFragment(FragmentHome())
            }
            true
        }

        supportFragmentManager.beginTransaction().apply {
            add(R.id.fm,FragmentHome())
            commit()
        }


    }

    fun setFragment(fragment : Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fm,fragment)
            commit()
        }
    }




}