package com.example.weatherapp.model

import android.content.Context
import com.example.weatherapp.view.CustomApplication
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherAPI {
    // api.openweathermap.org/data/2.5/forecast?zip={zip code},{country code}&appid={your api key}

    @GET("forecast")
    fun getWeather(
        @Query("zip") zipCode: String,
        @Query("appid") apikey: String
    ) : Call<PokoWeatherData>

    companion object {
        val baseUrl = "https://api.openweathermap.org/data/2.5/"

        fun initRetrofit(): WeatherAPI {
            var retrofit =
                Retrofit.Builder()
                    .client(printRequestLog(CustomApplication.getApplication()))
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(WeatherAPI::class.java)
        }

        fun printRequestLog(context: Context): OkHttpClient {

            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS

            val client: OkHttpClient =
                OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
            return client
        }

    }
}