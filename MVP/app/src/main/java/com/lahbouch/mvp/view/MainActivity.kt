package com.lahbouch.mvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.lahbouch.mvp.Person
import com.lahbouch.mvp.R
import com.lahbouch.mvp.presenter.IMainPresenter
import com.lahbouch.mvp.presenter.MainPresenter
import java.util.*

class MainActivity : AppCompatActivity() , MainPresenter.IView {
    lateinit var textViewResult : TextView
    lateinit var editTextName : EditText
    lateinit var editTextYear : EditText
    lateinit var buttonCalc : Button
    val presenter : MainPresenter = MainPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewResult = findViewById(R.id.textViewResult)
        editTextName = findViewById(R.id.editTextTextName)
        editTextYear = findViewById(R.id.editTextIntYear)
        buttonCalc = findViewById(R.id.buttonCalcAge)

        buttonCalc.setOnClickListener {
            val name = editTextName.text.toString()
            val year = editTextYear.text.toString()
            presenter.CalculateAge(name,year)
        }

    }

    override fun updateResult(p: Person) {
        textViewResult.text = "name : ${p.name}, age : ${p.age}"
    }


}