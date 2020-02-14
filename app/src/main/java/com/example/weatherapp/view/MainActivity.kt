package com.example.weatherapp.view

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.model.PokoWeatherData
import com.example.weatherapp.viewmodel.WeatherViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

   private val weatherViewModel: WeatherViewModel =
       ViewModelProvider(this, object : ViewModelProvider.Factory {

            override fun <T : ViewModel?> create(modelClass: Class<T>): T {

                return WeatherViewModel(application = CustomApplication()) as T
            }
       }).get(WeatherViewModel::class.java)

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // if(showZipFeature())
        weatherViewModel.dataWeatherList.observe(this, object : Observer<PokoWeatherData> {

                override fun onChanged(t: PokoWeatherData?) {

                    recycler_view.layoutManager = LinearLayoutManager(this@MainActivity)
                    val adapter = WeatherAdapter()
                    adapter.dataSet = t
                    recyclerView.adapter = adapter
                }
            })
        recyclerView = findViewById(R.id.recycler_view)
    }

    private fun showZipFeature(): Boolean {

        val sharedPreferences = getSharedPreferences(
            "WeatherZipCode",
            Context.MODE_PRIVATE
        )

        val zipCode = sharedPreferences.getString("zip_code", "N/A")
        if(zipCode.equals("N/A"))
            return true
        else return false
        /*
        // TODO Check is ZipCode and Units are not empty
        // Have this code in The settings screen
        val sharedPreferences2 =
            getSharedPreferences("WeatherZipCode", Context.MODE_PRIVATE)
        val editor = sharedPreferences2.edit()
        editor.putString("zip_code", tvZipCode.text)
        editor.putString("units", tvUnits.text)
        editor.commit()
        */
    }
}
