package com.lahbouch.infoscities.view.fragments

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.lahbouch.infoscities.R
import com.lahbouch.infoscities.view.Contracts
import com.lahbouch.infoscities.view.HomeActivity
import com.lahbouch.infoscities.viewModel.HomeViewModel


class SignUpFragment() : Fragment(R.layout.fragment_sign_up) {
     var activity : Contracts.HomeContract? = null
    lateinit var et_signup_email : EditText
    lateinit var et_signup_pwd : EditText
    lateinit var btn_signup : Button
    lateinit var vm : HomeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_signup = view.findViewById(R.id.btn_signup)
        et_signup_email = view.findViewById(R.id.et_signup_email)
        et_signup_pwd = view.findViewById(R.id.et_signup_pwd)
        vm = HomeViewModel(activity)


        btn_signup.setOnClickListener {
            val email = et_signup_email.text.toString()
            val pwd = et_signup_pwd.text.toString()
            et_signup_email.text.clear()
            et_signup_pwd.text.clear()
            vm.onSincrireClick(email,pwd)

        }



    }



}