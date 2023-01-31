package com.lahbouch.mvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lahbouch.mvvm.model.Person
import com.lahbouch.mvvm.repository.MainRepository

class MainViewModel : ViewModel() {
    val mainRepository = MainRepository()
    fun calculateAge(name:String,year : String) : LiveData<Person>{

        val personLiveData : LiveData<Person> = mainRepository.calculateAge(name,year)
        return personLiveData
    }
}