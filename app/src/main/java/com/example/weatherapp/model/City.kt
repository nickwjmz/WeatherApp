package com.example.weatherapp.model

import java.util.*

data class City(
    var id: Int,
    var name: String,
    var country: String,
    var timeZone: Int,
    var sunrise: Long,
    var sunset: Long
)