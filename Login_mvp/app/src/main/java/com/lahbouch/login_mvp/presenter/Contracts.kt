package com.lahbouch.login_mvp.presenter

import android.app.Person

interface Contracts{
    interface IMainActivityPresenter {
        fun onLoginClick(email : String,password : String)
    }
}