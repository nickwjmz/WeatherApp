package com.example.weatherapp.model

import androidx.room.PrimaryKey
import java.util.*

data class City(
    var id: Int,
    var name: String,
    var country: String
)