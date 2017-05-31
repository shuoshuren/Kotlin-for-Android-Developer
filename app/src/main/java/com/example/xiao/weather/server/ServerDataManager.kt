package com.example.xiao.weather.server

import com.example.xiao.weather.domain.ForecastList
import java.util.*
import java.util.concurrent.TimeUnit
import com.example.xiao.weather.domain.Forecast as ModelForecast

/**
 * Created by xiao on 2017/5/31.
 */
class ServerDataManager {
    fun convertToDomain(zipCode: Long, forecast: ForecastList) = with(forecast) {
        ForecastList(zipCode, city, country, convertForecastListToDomain(dailyForecast))
    }

    private fun convertForecastListToDomain(list: List<ModelForecast>): List<ModelForecast> {
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(date = dt.toString()))
        }
    }

    private fun convertForecastItemToDomain(forecast: ModelForecast) = with(forecast) {
        ModelForecast(date, description, high, low,
                generateIconUrl(iconUrl))
    }

    private fun generateIconUrl(iconCode: String) = "http://openweathermap.org/img/w/$iconCode.png"
}