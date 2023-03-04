package com.lahbouch.infoscities.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.lahbouch.infoscities.R
import com.lahbouch.infoscities.adapters.FragementAdapter
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class HomeActivity : AppCompatActivity(), Contracts.HomeContract {

    lateinit var tab_layout: TabLayout
    lateinit var view_pager: ViewPager2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()

        tab_layout = findViewById(R.id.home_tab_layout)
        view_pager = findViewById(R.id.home_viewpager)

        val frgAdapter = FragementAdapter(this)
        view_pager.adapter = frgAdapter

        TabLayoutMediator(tab_layout, view_pager) { tab, position ->
            tab.text = FragementAdapter.tabs[position]
        }.attach()
    }

    override fun showToast(title: String, msg: String) {
//        Motion
        MotionToast.setInfoBackgroundColor(R.color.black)
        MotionToast.setInfoColor(R.color.bg_info)
        MotionToast.createColorToast(
            this,
            title,
            msg,
            MotionToastStyle.INFO,
            MotionToast.GRAVITY_BOTTOM,
            MotionToast.LONG_DURATION,
            ResourcesCompat.getFont(this, R.font.normal)
        )
//        Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
    }

    override fun startMainActivty(email: String) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("email", email)
        startActivity(intent)
    }


}