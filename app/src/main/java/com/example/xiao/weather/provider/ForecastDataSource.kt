package com.example.xiao.weather.provider

import com.example.xiao.weather.domain.Forecast
import com.example.xiao.weather.domain.ForecastList

/**
 * Created by xiao on 2017/5/31.
 */
interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode:Long,date:Long):ForecastList?
    fun requestDayForecast(id: Long): Forecast?
}