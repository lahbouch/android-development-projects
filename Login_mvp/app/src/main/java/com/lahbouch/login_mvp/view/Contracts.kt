package com.lahbouch.login_mvp.view

import com.lahbouch.login_mvp.model.User

interface Contracts {
    interface IMainActivity{
        fun update(u : User)
    }

}