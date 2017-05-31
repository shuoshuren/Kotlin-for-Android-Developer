package com.example.xiao.weather.db

import com.example.xiao.weather.db.model.CityForecast
import com.example.xiao.weather.db.model.DayForecast
import com.example.xiao.weather.domain.Forecast
import com.example.xiao.weather.domain.ForecastList


/**
 * Created by xiao on 2017/5/27.
 */
class DbDataMapper {
    fun convertToDomain(forecast: CityForecast) = with(forecast){
        val daily = dailyForecast.map { convertDayToDomain(it) }
        ForecastList(_id,city,country,daily)

    }

    fun convertDayToDomain(dayForecast: DayForecast) = with(dayForecast){
        Forecast(_id,date.toString(),description,high,low,iconUrl)
    }

    fun  convertFromDomain(forecast: ForecastList) = with(forecast){
        val daily = dailyForecast.map { convertDayFromDomain(id,it) }
        CityForecast(id,city,country,daily)
    }

    private fun convertDayFromDomain(cityId: Long, forecast: Forecast): DayForecast {

        with(forecast){
            return DayForecast(date.toLong(),description,high,low,iconUrl,cityId)
        }
    }
}