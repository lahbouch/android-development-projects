package com.lahbouch.mybroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import android.widget.Toast.*

class myReceiver() : BroadcastReceiver() {





    override fun onReceive(context: Context?, intent: Intent?) {

        val action = intent?.action
        val isEnabled = intent?.getBooleanExtra("state",false)


        if (action == Intent.ACTION_AIRPLANE_MODE_CHANGED){

            if (isEnabled == true){
//                view.setBgColor(android.R.color.holo_green_dark)
                makeText(context, "enabled", LENGTH_SHORT).show()
//
            }else{
//                view.setBgColor(android.R.color.holo_red_dark)
                makeText(context, "disabled", LENGTH_SHORT).show()

            }
        }
    }
}