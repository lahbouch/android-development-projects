package com.lahbouch.services

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MyService : Service() {

    lateinit var mp : MediaPlayer

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(applicationContext, "oncreate", Toast.LENGTH_SHORT).show()
    }
    //on null
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mp = MediaPlayer.create(applicationContext,Settings.System.DEFAULT_RINGTONE_URI)
        mp.isLooping = true
        mp.start()
        Toast.makeText(applicationContext, "onStartCommand", Toast.LENGTH_SHORT).show()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        Toast.makeText(applicationContext, "Destroy", Toast.LENGTH_SHORT).show()
mp.stop()
        super.onDestroy()
    }

    //on Result
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}