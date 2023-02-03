package com.lahbouch.viewpagerproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var viewPager : ViewPager2
    lateinit var tabLayout : TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)

        val data = mutableListOf(
            "page 1",
            "page 2"
        )


        val adapter = FragmentsAdapter(this,data)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout,viewPager){
            tab,position -> tab.text = data[position]
        }.attach()




    }
}