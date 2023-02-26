package com.lahbouch.mybroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import android.widget.Toast.*

class myReceiver(val view : MainActivity) : BroadcastReceiver() {


    override fun onReceive(context: Context?, intent: Intent?) {

        makeText(context, "triggerd", LENGTH_SHORT).show()
        val action = intent?.action
        val isEnabled = intent?.getBooleanExtra("state",false)
        val mp = MediaPlayer.create(context,Settings.System.DEFAULT_RINGTONE_URI)

        if (action == Intent.ACTION_AIRPLANE_MODE_CHANGED){

            if (isEnabled == true){
                view.setBgColor(android.R.color.holo_green_dark)
//                mp.start()
            }else{
                view.setBgColor(android.R.color.holo_red_dark)
                mp.stop()
            }
        }
    }
}