package com.lahbouch.infoscities.viewModel

interface Contracts {
    interface IMainViewModel {
        fun onExploreClick(contry_name: String)
    }

    interface IHomeViewModel {
        fun onConnectClick(email: String, pwd: String)
        fun onSincrireClick(email: String, pwd: String)
    }

    interface ICityViewModel {
        fun onStart(contry_name: String)
    }

}