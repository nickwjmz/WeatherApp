package com.example.weatherapp.view

import android.app.Application
import android.content.Context

class CustomApplication : Application() {
    // Purpose of this class is to pre execute some process before
    // It becomes visible to the user

    companion object{
        private var weatherApplicationContext : Context? = null

        fun getApplication(): Context{
            return weatherApplicationContext!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        weatherApplicationContext = baseContext
    }

}