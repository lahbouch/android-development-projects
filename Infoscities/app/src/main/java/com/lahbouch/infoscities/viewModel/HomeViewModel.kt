package com.lahbouch.infoscities.viewModel

import android.content.Intent
import android.view.ViewParent
import android.widget.Toast
import com.lahbouch.infoscities.model.User
import com.lahbouch.infoscities.repository.UserRepository
import com.lahbouch.infoscities.view.CityActivity
import com.lahbouch.infoscities.view.HomeActivity

class HomeViewModel(val view: com.lahbouch.infoscities.view.Contracts.HomeContract?) :
    Contracts.IHomeViewModel {


    private val ERROR_MSG = "error de saisie!"
    private val ONSUCCES = "compte cree avec success"
    private val USER_ALREADY_EXISTS = "ce compte est deja exists!"
    private val NO_USER_EXISTS = "no compte exists!"

    private val EMAIL_PATTERN: Regex =
        Regex("^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))\$")


    private val userRepo = UserRepository()


    private val PWD_MIN_LENGTH = 8





    fun emailValidator(email : String) : Boolean{
        val EMAIL_VALIDATORS = mutableListOf(
            email.trim().isBlank(),
            email.trim().isEmpty(),
            !email.matches(EMAIL_PATTERN)
        )

        return EMAIL_VALIDATORS.contains(true)
    }

    fun pwdValidator(pwd: String): Boolean {
        val PWD_VALIDATORS = mutableListOf(
            pwd.trim().length < PWD_MIN_LENGTH
        )
        return PWD_VALIDATORS.contains(true)
    }

    override fun onConnectClick(email: String, pwd: String) {

        if (emailValidator(email) || pwdValidator(pwd)) {
            view!!.showToast("ERROR_MSG", ERROR_MSG)
            return
        }

        if (userRepo.getUser(email, pwd) == null) {
            view!!.showToast("NO_USER_EXISTS", NO_USER_EXISTS)
            return
        }


        view!!.startMainActivty(email)
    }

    override fun onSincrireClick(email: String, pwd: String) {

        if (emailValidator(email) || pwdValidator(pwd)) {
            view!!.showToast("ERROR_MSG", ERROR_MSG)
            return
        }

        if (!userRepo.addUser(email, pwd)) {
            view!!.showToast("USER_ALREADY_EXISTS", USER_ALREADY_EXISTS)
            return
        }
        view!!.showToast("SUCCES", ONSUCCES)
    }


}