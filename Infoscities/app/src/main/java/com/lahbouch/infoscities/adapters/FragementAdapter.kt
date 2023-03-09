package com.lahbouch.infoscities.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.lahbouch.infoscities.view.Contracts
import com.lahbouch.infoscities.view.fragments.LoginFragment
import com.lahbouch.infoscities.view.fragments.SignUpFragment

class FragementAdapter(activity : FragmentActivity) : FragmentStateAdapter(activity) {

     companion object{
         val tabs = mutableListOf("Connecter","S'inscrire")
     }

    override fun getItemCount(): Int {
        return tabs.size
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> LoginFragment().apply {
                this.activity = activity
            }
            1 -> SignUpFragment().apply {
                this.activity = activity
            }
            else -> LoginFragment().apply {
                this.activity = activity
            }
        }
    }
}