package com.lahbouch.infoscities.viewModel

import com.lahbouch.infoscities.adapters.CityAdapter
import com.lahbouch.infoscities.repository.CountryRepository

class CityViewModel(val view: com.lahbouch.infoscities.view.Contracts.CityContract) :
    Contracts.ICityViewModel {

    val countryRepo = CountryRepository()

    override fun onStart(contry_name: String) {


        if (countryRepo.getCitys(contry_name).size == 0) {
            view.showErrorLayout()
            return
        }

        view.HideErrorLayout()

        val adapter = CityAdapter(countryRepo.getCitys(contry_name))

        view.bindViewPager(adapter)

    }


}