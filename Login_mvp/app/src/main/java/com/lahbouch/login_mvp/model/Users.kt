package com.lahbouch.login_mvp.model

class Users {
    companion object{
        val list = mutableListOf<User>(
            User("test1@test.com","test1234"),
            User("test2@test.com","test2345")
        )
    }
}