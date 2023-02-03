package com.lahbouch.swipable_views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ImgAdapter(val data : MutableList<Int>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class viewHolder(view : View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val img : ImageView = holder.itemView.findViewById(R.id.imageView)
        img.setImageResource(data.get(position))
    }

    override fun getItemCount(): Int {
       return data.size
    }
}