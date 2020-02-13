package com.example.weatherapp.model

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitEndpoint {
    // api.openweathermap.org/data/2.5/forecast?zip={zip code},{country code}&appid={your api key}
    // apikey = ff7a53714c662908453f27ee7df7f6a2
    // US ISO code = 840

    @GET("forecast")
    fun getZip(@Path())
    fun getWeather(): Call<PokoWeatherData>

    companion object{
        val country = "840" // US Code
        val apikey = "ff7a53714c662908453f27ee7df7f6a2"

        val baseUrl = "https://api.openweathermap.org/data/2.5/forecast?"
        val REST = ","+country+"&appid="+apikey

        fun initRetrofit(): RetrofitEndpoint{
            var retrofit =
                Retrofit.Builder().baseUrl(baseUrl)
        }
    }



}