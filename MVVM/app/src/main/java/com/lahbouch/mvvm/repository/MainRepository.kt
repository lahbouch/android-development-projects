package com.lahbouch.mvvm.repository

import androidx.lifecycle.MutableLiveData
import com.lahbouch.mvvm.model.Person
import java.util.Calendar

class MainRepository : IMainRepository {
    override fun calculateAge(name: String, year: String) : MutableLiveData<Person> {
        val mainLiveData = MutableLiveData<Person>()
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        val age = currentYear - year.toInt()
        val p = Person(name,age)
        mainLiveData.postValue(p)
        return mainLiveData
    }
}