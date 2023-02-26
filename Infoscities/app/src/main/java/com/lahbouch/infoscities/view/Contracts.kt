package com.lahbouch.infoscities.view

import androidx.recyclerview.widget.RecyclerView

interface Contracts {
    interface MainContract{
        fun startExploring(contry_name : String)
        fun showToast(msg : String)
    }
    interface HomeContract{
        fun showToast(title : String,msg : String)
        fun startMainActivty(email:String)

    }
    interface CityContract{
        fun bindViewPager(adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>)

        fun showErrorLayout()

        fun HideErrorLayout()

    }
}