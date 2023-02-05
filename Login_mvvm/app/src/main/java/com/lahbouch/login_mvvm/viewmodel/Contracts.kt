package com.lahbouch.login_mvvm.viewmodel

interface Contracts {
    interface MainViewModel{
        fun onLoginBtnClick(email : String,password : String)
    }
}