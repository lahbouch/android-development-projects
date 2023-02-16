package com.lahbouch.mybroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import android.widget.Toast.*

class myReceiver(val view : MainActivity) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        makeText(context, "triggerd", LENGTH_SHORT).show()
        val action = intent?.action
        val isEnabled = intent?.getBooleanExtra("state",false)

        if (action == Intent.ACTION_AIRPLANE_MODE_CHANGED){

            if (isEnabled == true){
                view.setBgColor(android.R.color.holo_green_dark)
            }else{
                view.setBgColor(android.R.color.holo_red_dark)

            }
        }
    }
}