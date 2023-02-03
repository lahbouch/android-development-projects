package com.lahbouch.RecycleView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var  recyclerViewContainer : RecyclerView
    lateinit var btn_add : Button
    lateinit var et_add : EditText
    lateinit var TodoAdapter : TodoAdapter
    private val data : MutableList<Todo> = mutableListOf(
        Todo("study mvvm",false),
        Todo("doing recycle view",true)

    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewContainer = findViewById(R.id.recycleView)
        btn_add  = findViewById(R.id.button)
        et_add  = findViewById(R.id.editTextTitle)
        TodoAdapter = TodoAdapter(data)

        recyclerViewContainer.adapter = TodoAdapter
        recyclerViewContainer.layoutManager = LinearLayoutManager(this)

        btn_add.setOnClickListener {
            val title = et_add.text.toString()
            val todo = Todo(title,false)
            data.add(todo)
            TodoAdapter.notifyItemInserted(data.size-1)
        }

    }






}