package com.lahbouch.login_mvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.lahbouch.login_mvvm.R
import com.lahbouch.login_mvvm.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() , Contracts.IMain {

    val mainViewModel = MainViewModel(this)
    lateinit var btn_login : Button
    lateinit var et_email : EditText
    lateinit var et_pwd : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login = findViewById(R.id.btn_login)
        et_email = findViewById(R.id.et_email)
        et_pwd = findViewById(R.id.et_pwd)

        btn_login.setOnClickListener {

            val email = et_email.text.toString()
            val pwd = et_pwd.text.toString()
            mainViewModel.onLoginBtnClick(email,pwd)
        }

    }



    override fun showToast(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    override fun onSuccess(DestinationActivity: Class<AppCompatActivity>) {
        val intent = Intent(this,HomeActivity().javaClass)
        startActivity(intent)
    }
}