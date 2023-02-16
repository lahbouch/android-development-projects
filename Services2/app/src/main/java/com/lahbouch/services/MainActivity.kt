package com.lahbouch.services

import android.app.Service
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity()  {

    lateinit var myIntent : Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myIntent = Intent(this,MyService::class.java)
    }



    fun startService(view: View) {
        startService(myIntent)
    }
    fun stopService(view: View) {
        stopService(myIntent)
    }

    override fun onDestroy() {
        super.onDestroy()

    }
}