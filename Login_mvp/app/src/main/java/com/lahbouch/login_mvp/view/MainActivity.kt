package com.lahbouch.login_mvp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.lahbouch.login_mvp.R
import com.lahbouch.login_mvp.model.User
import com.lahbouch.login_mvp.presenter.MainActivityPresenter

class MainActivity : AppCompatActivity() , Contracts.IMainActivity {

    lateinit var editText_email : EditText
    lateinit var editText_password : EditText
    lateinit var button_logIn : Button
    val presenter = MainActivityPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText_email = findViewById(R.id.editTextEmail)
        editText_password = findViewById(R.id.editTextPassword)
        button_logIn = findViewById(R.id.buttonLogin)

        button_logIn.setOnClickListener {

            val email  = editText_email.text.toString()
            val password = editText_password.text.toString()

            presenter.login(email,password)


        }


    }

    override fun update(u: User) {
        val intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)
    }
}