package com.lahbouch.login_mvp.presenter

import com.lahbouch.login_mvp.model.Users
import com.lahbouch.login_mvp.view.Contracts.IMainActivity

class MainActivityPresenter(val view : IMainActivity ) : Contracts.IMainActivityPresenter {
    override fun login(email: String, password: String) {
        Users.list.forEach { user ->
            if (user.email == email && user.password == password ){
                view.update(user)
            }
        }
    }
}