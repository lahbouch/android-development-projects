package com.lahbouch.infoscities.viewModel

import android.widget.Toast

class MainViewModel(val view : com.lahbouch.infoscities.view.Contracts.MainContract) : Contracts.IMainViewModel {

    private val ERROR_MSG = "s'il vous plais entrez un pays exists!"
    private val MAX_LENGTH = 30

    override fun onExploreClick(contry_name : String) {

        if (contry_name.length > MAX_LENGTH || contry_name.contains(Regex("[1-9]"))){
           view.showToast(ERROR_MSG)
            return
        }



        view.startExploring(contry_name)
    }
}