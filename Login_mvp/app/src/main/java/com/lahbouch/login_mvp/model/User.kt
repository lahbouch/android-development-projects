package com.lahbouch.login_mvp.model

data class User(val email : String,val password : String){
    companion object{
        val list = mutableListOf(
            User("test1@test.com","test1234"),
            User("test2@test.com","test2345")
        )
    }
}
