package com.lahbouch.login_mvvm.model

data class User(val email : String,val password : String){
   companion object
   {
       val all = mutableListOf<User>(
           User("test@test.com","123")
       )
   }


}
