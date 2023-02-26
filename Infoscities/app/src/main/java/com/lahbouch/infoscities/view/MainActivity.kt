package com.lahbouch.infoscities.view

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.lahbouch.infoscities.R
import com.lahbouch.infoscities.viewModel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(),Contracts.MainContract {

    lateinit var btn_start : Button
    lateinit var et_contry : EditText
    lateinit var tv_welcome : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        btn_start = findViewById(R.id.btn_q)
        et_contry = findViewById(R.id.et_contry)
        tv_welcome = findViewById(R.id.welcome_model)


        showWelcomePanel()








        val viewModel = MainViewModel(this)
        btn_start.setOnClickListener {
            val  contry_name = et_contry.text.toString()
            viewModel.onExploreClick(contry_name)
        }
    }

     override fun startExploring(contry_name: String) {
        val intent = Intent(this,CityActivity::class.java)
        intent.apply {
            putExtra("contry",contry_name)
        }
         et_contry.text.clear()
        startActivity(intent)
    }

    override fun showToast(msg : String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun showWelcomePanel(){
        val msg = intent.getStringExtra("email")
        val text = tv_welcome.text.toString().format(msg)

        GlobalScope.launch(Dispatchers.Main) {
            tv_welcome.apply {
                this.text = text
                visibility = View.VISIBLE


            }
            delay(3000L)
            tv_welcome.visibility = View.GONE


        }


    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putString("sss","sss")
    }


}