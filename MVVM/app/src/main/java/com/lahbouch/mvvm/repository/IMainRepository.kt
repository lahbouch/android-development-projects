package com.lahbouch.mvvm.repository

import androidx.lifecycle.MutableLiveData
import com.lahbouch.mvvm.model.Person

interface IMainRepository {
    fun calculateAge(name : String,year : String) : MutableLiveData<Person>
}