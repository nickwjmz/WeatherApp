package com.example.weatherapp.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R

class WeatherViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

    val tvDaily: TextView =
        itemView.findViewById(R.id.tv_item_daily)

    val tvHourly: TextView =
        itemView.findViewById(R.id.tv_item_hourly)
}