package com.lahbouch.login_mvvm.repository

import com.lahbouch.login_mvvm.model.User

interface Contracts {
    interface IUser{
        fun getAll() : MutableList<User>
        fun findUser(email : String,password : String) : User?
    }
}