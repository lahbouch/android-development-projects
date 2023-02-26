package com.lahbouch.infoscities.repository

import com.lahbouch.infoscities.model.User

class UserRepository {

    val users = User.users

    fun getUser(email : String,pwd : String) : User?{
        return users.find {
            it.email == email && it.pwd == pwd
        }
    }

    fun isUserExists(email : String,pwd : String) : Boolean{
        return when(getUser(email,pwd)){
            null -> false
            else -> true
        }
    }

    fun addUser(email : String,pwd : String) : Boolean{
        val user = User(email, pwd)
        if (isUserExists(email,pwd)){
            return false
        }
        User.users.add(user)
        return true
    }
}