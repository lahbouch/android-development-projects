package com.lahbouch.login_mvvm.repository

import com.lahbouch.login_mvvm.model.User

class UserRepository : Contracts.IUser {

    override fun getAll(): MutableList<User> {
        return User.all
    }

    override fun findUser(email: String, password: String): User? {
        return User.all.find {
            it.email == email && it.password == password
        }
    }
}