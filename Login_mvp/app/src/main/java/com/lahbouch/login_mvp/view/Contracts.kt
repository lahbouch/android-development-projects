package com.lahbouch.login_mvp.view

import com.lahbouch.login_mvp.model.User

interface Contracts {
    interface IMainActivity{

        fun authenticated(u : User?)
        fun errorEmail(error : String)
        fun errorPwd(error : String)
    }

}