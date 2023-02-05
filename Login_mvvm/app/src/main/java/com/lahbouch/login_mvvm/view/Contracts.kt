package com.lahbouch.login_mvvm.view

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity

interface Contracts {
    interface IMain{
        fun showToast(msg : String)
        fun onSuccess(DestinationActivity : Class<AppCompatActivity>)

    }
}