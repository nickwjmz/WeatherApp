package com.example.weatherapp.model

data class WeatherData(
    var dt: Long,
    var main: MainInfo,
    var Weather: List<Weather>
    )

data class MainInfo(
    var temp: Float,
    var feels_like: Float,
    var temp_min: Float,
    var temp_max: Float,
    var humidity: Int
)

data class Weather(
    var id: Int,
    var mainWeather: String,
    var description: String,
    var icon: String
)