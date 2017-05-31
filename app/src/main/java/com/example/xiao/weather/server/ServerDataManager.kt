package com.example.xiao.weather.server

import com.example.xiao.weather.domain.Forecast
import com.example.xiao.weather.domain.ForecastList
import com.example.xiao.weather.model.ForecastResult
import com.example.xiao.weather.model.ModelForecast
import java.util.*
import java.util.concurrent.TimeUnit


/**
 * Created by xiao on 2017/5/31.
 */
class ServerDataManager {

    fun convertToDomain(zipCode: Long, forecast: ForecastResult) = with(forecast) {
        ForecastList(zipCode, city.name, city.country, convertForecastListToDomain(list))
    }

    private fun convertForecastListToDomain(list: List<ModelForecast>): List<Forecast> {

        return list.mapIndexed { i, modelForecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(modelForecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: ModelForecast) = with(forecast){
        Forecast(-1,dt.toString(),weather[0].description,temp.max.toInt(),temp.min.toInt(),generateIconUrl(weather[0].icon))
    }


    private fun generateIconUrl(iconCode: String) = "http://openweathermap.org/img/w/$iconCode.png"
}