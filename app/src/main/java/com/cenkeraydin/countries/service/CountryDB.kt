package com.cenkeraydin.countries.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cenkeraydin.countries.data.model.Country

@Database(entities = [Country::class], version = 1)
abstract class CountryDB  : RoomDatabase() {

    abstract fun countryDao(): CountryDAO

    companion object{
        @Volatile private var instance: CountryDB? = null

        operator fun invoke(context: Context) = instance ?: synchronized(this){
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            CountryDB::class.java,
            "countrydatabase"
        ).build()
    }

}