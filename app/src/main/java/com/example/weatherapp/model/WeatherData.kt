package com.example.weatherapp.model

import androidx.room.Entity

@Entity(tableName = "weather_table")
data class WeatherData(
    var dt: Long,
    var main: MainInfo,
    var weather: List<weather>
    )

data class MainInfo(
    var temp: Float,
    var temp_min: Float,
    var temp_max: Float
)

data class weather(
    var id: Int,
    var mainWeather: String,
    var description: String,
    var icon: String
)