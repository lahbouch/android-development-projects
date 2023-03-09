package com.example.listviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity()  {
    lateinit var lv : ListView
    lateinit var rv : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //list view
        lv = findViewById(R.id.listView1)

        //resource array
        val arr = resources.getStringArray(R.array.menu1)

        //adapter
        val aa : ArrayAdapter<CharSequence> = ArrayAdapter(this,android.R.layout.simple_list_item_1,arr)

        //assign adapter
        lv.adapter = aa;

        //events
        lv.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(
                this,
                "${arr.get(position)}  click",
                Toast.LENGTH_SHORT
            ).show() }

        //long click
        lv.setOnItemLongClickListener { parent, view, position, id ->
            Toast.makeText(
                this,
                "${arr.get(position)} long click",
                Toast.LENGTH_SHORT
            ).show()
            false
        }




        val rv_arr = resources.getStringArray(R.array.menu2)
        rv = findViewById(R.id.recycleView)
        val myAdapter = myAdapter(rv_arr)
        rv.adapter = myAdapter


        rv.setOnLongClickListener {
            Toast.makeText(this, "salam", Toast.LENGTH_SHORT).show()
            true
        }



}



}
