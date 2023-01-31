package com.lahbouch.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import com.lahbouch.mvvm.R
import com.lahbouch.mvvm.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var textViewResult : TextView
    lateinit var editTextName : EditText
    lateinit var editTextYear : EditText
    lateinit var buttonCalc : Button
    val mainViewModelProvider : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewResult = findViewById(R.id.textViewResult)
        editTextName = findViewById(R.id.editTextTextName)
        editTextYear = findViewById(R.id.editTextIntYear)
        buttonCalc = findViewById(R.id.buttonCalcAge)

        buttonCalc.setOnClickListener {
            val name = editTextName.text.toString()
            val age = editTextYear.text.toString()
            mainViewModelProvider.calculateAge(name,age).observe(this,{
                textViewResult.text = "Name : ${it.name}, Age : ${it.age}"
            })
        }
    }


}