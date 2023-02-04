package com.lahbouch.login_mvp.presenter

import com.lahbouch.login_mvp.model.User
import com.lahbouch.login_mvp.view.Contracts.IMainActivity

class MainActivityPresenter(val view : IMainActivity ) : Contracts.IMainActivityPresenter {

    val ERROR_EMAIL: String = "Check your email!"
    val ERROR_PWD : String = "Check your password!"

    override fun onLoginClick(email: String, password: String) {


        val userAuthenticated = User.list.find { user -> user.email == email }

        if (!User.list.any { user -> user.email == email }){
            view.errorEmail(ERROR_EMAIL)
            return
        }

        if (!User.list.any { user -> user.password == password }) {
            view.errorPwd(ERROR_PWD)
            return
        }


        view.authenticated(userAuthenticated)


    }
}