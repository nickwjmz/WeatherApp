package com.example.weatherapp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [WeatherData::class], version=1, exportSchema = false)
abstract class WeatherRoomDB(): RoomDatabase() {

    abstract fun weatherDao(): WeatherDao

    companion object {
        @Volatile
        private var INSTANCE: WeatherRoomDB? = null

        fun getDatabase(context: Context): WeatherRoomDB{
            val tempInstance = INSTANCE
            if (tempInstance != null)
                return tempInstance
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WeatherRoomDB::class.java,
                    "weatherdb").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}