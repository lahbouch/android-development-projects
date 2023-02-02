package com.lahbouch.login_mvp.presenter

import android.app.Person

interface Contracts{
    interface IMainActivityPresenter {
        fun login(email : String,password : String)
    }
}