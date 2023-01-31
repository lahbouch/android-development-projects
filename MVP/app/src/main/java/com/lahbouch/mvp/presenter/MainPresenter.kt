package com.lahbouch.mvp.presenter

import android.view.View
import com.lahbouch.mvp.Person
import java.util.Calendar

class MainPresenter(private val view : IView) : IMainPresenter  {

    override fun CalculateAge(name: String,year: String) {

        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        val age = currentYear - year.toInt()
        val p = Person(name,age)
        view.updateResult(p)

    }

    interface IView{
        fun updateResult(p : Person)
    }


}