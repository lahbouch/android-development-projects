package com.lahbouch.infoscities.repository

import com.lahbouch.infoscities.R
import com.lahbouch.infoscities.model.City
import com.lahbouch.infoscities.model.Country

class CountryRepository() {
    val country_maroc = Country("maroc", Country.country_maroc)

    val country_dz = Country("dz", Country.country_dz)


    fun getCitys(countryName: String): MutableList<City> {
        return when (countryName) {
            "maroc" -> country_maroc.citys
            "dz" -> country_dz.citys
            else -> mutableListOf()
        }
    }


}