package com.lahbouch.infoscities.Receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.view.View
import android.widget.Button
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    lateinit var btn : Button

    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "ok", Toast.LENGTH_SHORT).show()
        val action = intent?.action
        if (action == Intent.ACTION_AIRPLANE_MODE_CHANGED){
            if (intent.getBooleanExtra("state",false)
        ){
                btn.visibility = View.GONE
        }else{
            btn.visibility = View.VISIBLE
            }

    }
}
        fun registreBtn(btn : Button){
            this.btn = btn
        }









}