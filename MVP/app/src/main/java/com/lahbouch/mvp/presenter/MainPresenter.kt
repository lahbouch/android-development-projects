package com.lahbouch.mvp.presenter

import android.view.View
import android.widget.Toast
import com.lahbouch.mvp.Person
import java.util.Calendar

class MainPresenter(private val view : IView) : IMainPresenter  {

    override fun CalculateAge(name: String,year: String) {

        try {
            val currentYear = Calendar.getInstance().get(Calendar.YEAR)
            val age = currentYear - year.toInt()
            val p = Person(name,age)
            view.updateResult(p)
            view.showToast("operation success")
        }catch (e : NumberFormatException){
            view.showToast("year of birth is not a number")
        }



    }

    interface IView{
        fun updateResult(p : Person)
        fun showToast(msg : String)
    }


}