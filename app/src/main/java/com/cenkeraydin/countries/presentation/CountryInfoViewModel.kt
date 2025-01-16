package com.cenkeraydin.countries.presentation

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cenkeraydin.countries.data.model.Country
import com.cenkeraydin.countries.service.CountryDB
import kotlinx.coroutines.launch
import java.util.UUID

class CountryInfoViewModel(application: Application):BaseViewModel(application) {
    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom(uuid: Int){
        launch {
            val dao = CountryDB(getApplication()).countryDao()
            val country = dao.getCountry(uuid)
            countryLiveData.value = country
        }
    }
}