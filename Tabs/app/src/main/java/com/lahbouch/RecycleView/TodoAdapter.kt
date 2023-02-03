package com.lahbouch.RecycleView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class TodoAdapter(val data : MutableList<Todo>) : RecyclerView.Adapter<TodoAdapter.viewHolder>() {



    inner class viewHolder(view : View)  : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

        val title = holder.itemView.findViewById<TextView>(R.id.tvTitle)
        val checkBox = holder.itemView.findViewById<CheckBox>(R.id.cbDone)

        title.text = data[position].title
        checkBox.isChecked = data[position].isChecked

    }

    override fun getItemCount(): Int {
        return data.size
    }
}