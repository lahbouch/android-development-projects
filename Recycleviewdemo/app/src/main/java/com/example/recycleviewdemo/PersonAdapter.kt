package com.example.recycleviewdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class PersonAdapter(val data : MutableList<Person>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.personne,parent,false)
        view.setOnClickListener {
            Toast.makeText(parent.context, "test", Toast.LENGTH_SHORT).show()
        }
        view.setOnLongClickListener {
            Toast.makeText(parent.context, "long test", Toast.LENGTH_SHORT).show()
            true
        }
        return object : ViewHolder(view){}
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.pName).text = data[position].name
        holder.itemView.findViewById<TextView>(R.id.pGender).text = data[position].gender.toString()
        holder.itemView.findViewById<TextView>(R.id.pNationalite).text = data[position].nationalite

    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        recyclerView.layoutManager = GridLayoutManager(recyclerView.context,3,GridLayoutManager.VERTICAL,false)
    }

}