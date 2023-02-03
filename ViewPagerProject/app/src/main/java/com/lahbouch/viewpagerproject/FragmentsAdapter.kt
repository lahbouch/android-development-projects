package com.lahbouch.viewpagerproject

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentsAdapter(activity : FragmentActivity,val tabs : MutableList<String>) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return tabs.size
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
           0 -> Page1()
            1 -> Page2()
            else -> Page1()
        }
    }
}