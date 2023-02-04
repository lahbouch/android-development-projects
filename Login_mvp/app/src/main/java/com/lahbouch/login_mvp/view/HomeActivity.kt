package com.lahbouch.login_mvp.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.lahbouch.login_mvp.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val tv : TextView = findViewById(R.id.textViewWelcome)

        val msg = intent.getStringExtra("email")

        tv.text = tv.text.toString().format(msg)

    }
}