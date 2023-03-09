package com.example.listviewdemo

import android.animation.Animator
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class myAdapter(val data : Array<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class viewHolder(view : View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1,parent,false)

        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size;
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(android.R.id.text1).text = data[position]
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context,LinearLayoutManager.VERTICAL,true)
    }


//    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
//        Toast.makeText(holder.itemView.context, "${holder.itemView.findViewById<TextView>(android.R.id.text1)} recycled", Toast.LENGTH_SHORT).show()
//    }

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        super.onViewAttachedToWindow(holder)

    }



}