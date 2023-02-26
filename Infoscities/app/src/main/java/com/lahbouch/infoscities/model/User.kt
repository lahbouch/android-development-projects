package com.lahbouch.infoscities.model

data class User(val email : String,val pwd : String){
   companion object{
       val users = mutableListOf<User>(
           User(
               "test@test.com",
               "12345678"
           )
       )
   }
}
