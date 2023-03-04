package com.lahbouch.infoscities.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lahbouch.infoscities.R
import com.lahbouch.infoscities.model.City
import com.lahbouch.infoscities.model.Country
import com.lahbouch.infoscities.view.FullDesc

class CityAdapter(val data : MutableList<City>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class viewHolder(view : View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view =  LayoutInflater.from(parent.context).inflate(R.layout.city_component,parent,false)
        return viewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val cityImg = data.get(position).img
        val cityName = data.get(position).name
        val cityPeople = data.get(position).people
        val citySmallDesc = data.get(position).smallDesc
        val cityFullDesc = data.get(position).fullDesc
        val cityWebSite = data.get(position).website



        val iv_cityImg = holder.itemView.findViewById<ImageView>(R.id.cityImage)
        iv_cityImg.setImageResource(cityImg)


        val tv_cityName = holder.itemView.findViewById<TextView>(R.id.cityFullName)
        tv_cityName.setText(cityName)

        val tv_cityPeople = holder.itemView.findViewById<TextView>(R.id.cityPeople)
        tv_cityPeople.setText(cityPeople)

        val tv_citySmallDesc = holder.itemView.findViewById<TextView>(R.id.citySmallDesc)
        tv_citySmallDesc.setText(citySmallDesc)

        val btnInfo = holder.itemView.findViewById<Button>(R.id.btnInfo)

        btnInfo.setOnClickListener {
            val intent = Intent(holder.itemView.context,FullDesc::class.java).apply {
                putExtra("fullDesc",cityFullDesc)
                putExtra("website",cityWebSite)
            }
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }
}
