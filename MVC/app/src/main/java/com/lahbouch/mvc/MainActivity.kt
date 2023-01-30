package com.lahbouch.mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.reflect.Array.get
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    lateinit var textViewResult : TextView
    lateinit var editTextName : EditText
    lateinit var editTextYear : EditText
    lateinit var buttonCalc : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewResult = findViewById(R.id.textViewResult)
        editTextName = findViewById(R.id.editTextTextName)
        editTextYear = findViewById(R.id.editTextIntYear)
        buttonCalc = findViewById(R.id.buttonCalcAge)

        buttonCalc.setOnClickListener {
            buttonCalcOnClick()
        }

    }

    private fun buttonCalcOnClick() {
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        val age = currentYear - editTextYear.text.toString().toInt()
        val name = editTextName.text.toString()
        val p = Person(name,age)
        textViewResult.text = "Your name is ${name}, age is ${age}"
    }
}