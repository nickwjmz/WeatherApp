package com.example.weatherapp.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.model.PokoWeatherData

class WeatherAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var dataSet: PokoWeatherData? = null

    set(value) {
        field = value
        notifyDataSetChanged()
    }
    /* The code above does the same as this commented out code
    public void setDataSet (dataSet) {
        this.dataSet = dataSet
        notifyDataSetChanged()
    }*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}