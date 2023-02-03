package com.lahbouch.swipable_views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    lateinit var vpager : ViewPager2
    lateinit var adapter : ImgAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = mutableListOf<Int>(
            R.drawable.p1,
            R.drawable.p,
            R.drawable.p2,
            R.drawable.p4,
            R.drawable.p5
        )
        adapter = ImgAdapter(data)
        vpager = findViewById(R.id.viewPager)
        vpager.adapter = adapter

        vpager.orientation = ViewPager2.ORIENTATION_VERTICAL

        vpager.beginFakeDrag()
        vpager.fakeDragBy(-10f)
        vpager.endFakeDrag()

    }
}