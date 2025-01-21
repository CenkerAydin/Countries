package com.cenkeraydin.countries.util

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class CustomSharedPreferences {

    companion object{
        private val TIME = "time"
        private var sharedPreferences: SharedPreferences? = null
        @Volatile private var instance : CustomSharedPreferences? = null

        operator fun invoke(context: Context) = instance ?: synchronized(this){
            instance ?: buildSharedPreferences(context).also { instance = it }
        }

        private fun buildSharedPreferences(context :Context) : CustomSharedPreferences {
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            return CustomSharedPreferences()
        }
    }

    fun saveTime(time: Long){
        sharedPreferences?.edit()?.putLong(TIME, time)?.apply()
    }
    fun getTime() = sharedPreferences?.getLong(TIME, 0)
}