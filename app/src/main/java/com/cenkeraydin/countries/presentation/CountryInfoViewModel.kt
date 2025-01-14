package com.cenkeraydin.countries.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cenkeraydin.countries.data.model.Country

class CountryInfoViewModel:ViewModel() {
    val country = MutableLiveData<Country>()

    fun getDataFromRoom(){
        val country = Country("Turkey","Asia","Ankara","TRY","Turkish","www.ss.com")
        this.country.value = country
    }
}