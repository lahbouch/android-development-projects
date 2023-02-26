package com.lahbouch.infoscities.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.lahbouch.infoscities.R
import com.lahbouch.infoscities.view.Contracts
import com.lahbouch.infoscities.viewModel.HomeViewModel


class LoginFragment(val activity : Contracts.HomeContract) : Fragment(R.layout.fragment_login) {

    lateinit var et_login_email : EditText
    lateinit var et_login_pwd : EditText
    lateinit var btn_login : Button
    lateinit var vm : HomeViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_login = view.findViewById(R.id.btn_login)
        et_login_email = view.findViewById(R.id.et_login_email)
        et_login_pwd = view.findViewById(R.id.et_login_pwd)
        vm = HomeViewModel(activity)

        btn_login.setOnClickListener {
            val email = et_login_email.text.toString()
            val pwd = et_login_pwd.text.toString()
            et_login_email.text.clear()
            et_login_pwd.text.clear()
            vm.onConnectClick(email,pwd)
        }

    }




}