package com.example.weatherapp.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface WeatherDao {

    @Query("SELECT * FROM weather_table")
    fun getWeather(): LiveData<List<WeatherData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveCacheData(data: WeatherData)
}