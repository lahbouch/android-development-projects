package com.lahbouch.mybroadcast

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    lateinit var myReceiver: myReceiver
    lateinit var myIntentFilter: IntentFilter
    lateinit var myLayout : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myLayout = findViewById(R.id.test)


        myReceiver = myReceiver()


     

        myIntentFilter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(myReceiver,myIntentFilter)


    }


    fun setBgColor(color: Int){
        myLayout.setBackgroundResource(color)
        Toast.makeText(this, "bg", Toast.LENGTH_SHORT).show()
    }
}