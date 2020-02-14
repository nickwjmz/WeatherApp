package com.example.weatherapp.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.R
import com.example.weatherapp.model.PokoWeatherData
import com.example.weatherapp.model.WeatherAPI
import com.example.weatherapp.model.WeatherDao
import com.example.weatherapp.model.WeatherRoomDB
import com.example.weatherapp.view.CustomApplication
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherViewModel(application: CustomApplication) : AndroidViewModel(application) {
/*  val country = "840" // US Code
    val apikey = "ff7a53714c662908453f27ee7df7f6a2"*/
val dataWeatherList = MutableLiveData<PokoWeatherData>()

    fun getDataMovieList(): LiveData<PokoWeatherData> = dataWeatherList

    fun getWeather() {
        CustomApplication.getApplication().resources
            .getString(R.string.app_name)
        WeatherAPI.initRetrofit()
            .getWeather("30067", "ff7a53714c662908453f27ee7df7f6a2")
            .enqueue(object: Callback<PokoWeatherData>{

                override fun onFailure(call: Call<PokoWeatherData>, t: Throwable) {
                }

                override fun onResponse(
                    call: Call<PokoWeatherData>,
                    response: Response<PokoWeatherData>
                ) {
                    val weatherObjectDao = WeatherRoomDB.getDatabase(
                        CustomApplication.getApplication()).weatherDao()

                    dataWeatherList.value = response.body()
                }
            })
    }

}