package com.lahbouch.RecycleView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class TodoAdapter(val data : MutableList<Todo>) : RecyclerView.Adapter<TodoAdapter.viewHolder>() {



    inner class viewHolder(view : View)  : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

        TODO("IMPLEMENTING ON bIND")
    }

    override fun getItemCount(): Int {
        return data.size
    }
}