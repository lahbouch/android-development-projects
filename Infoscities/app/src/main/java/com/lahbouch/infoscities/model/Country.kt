package com.lahbouch.infoscities.model

import com.lahbouch.infoscities.R

data class Country(
    val name: String,
    val citys: MutableList<City>
) {
    companion object {
        val country_dz: MutableList<City> = mutableListOf(
            City(
                R.drawable.oran,
                R.string.oranCityName,
                R.string.oranSmallDesc,
                R.string.oranFullDesc,
                R.string.oranWebsite,
                R.string.oranHabitans
            ),
            City(
                R.drawable.alger,
                R.string.algerCityName,
                R.string.algerSmallDesc,
                R.string.algerFullDesc,
                R.string.algerWebsite,
                R.string.algerHabitans
            ),
        )

        val country_maroc = mutableListOf(
            City(
                R.drawable.rabat,
                R.string.rabatCityName,
                R.string.rabatSmallDesc,
                R.string.rabatFullDesc,
                R.string.rabatWebsite,
                R.string.rabatHabitans
            ),
            City(
                R.drawable.casablanca,
                R.string.casablancaCityName,
                R.string.casablancaSmallDesc,
                R.string.casablancaFullDesc,
                R.string.casablancaWebsite,
                R.string.casablancaHabitans
            )
        )

    }


}
