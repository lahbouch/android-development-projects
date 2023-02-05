package com.lahbouch.login_mvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.lahbouch.login_mvvm.model.User
import com.lahbouch.login_mvvm.repository.UserRepository
import com.lahbouch.login_mvvm.view.HomeActivity

class MainViewModel(val view : com.lahbouch.login_mvvm.view.Contracts.IMain) : Contracts.MainViewModel , ViewModel(){

    private val ERROR_MSG = "check your inputs"
    private val SUCCESS_MSG = "welcome"

    override fun onLoginBtnClick(email: String, password: String) {
        val userRepo = UserRepository()
        val result : User? = userRepo.findUser(email,password)
        if (result == null){
            view.showToast(ERROR_MSG)
        }else{
            view.showToast(SUCCESS_MSG)
            view.onSuccess(HomeActivity().javaClass)
        }
    }
}