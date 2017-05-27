package com.example.xiao.weather.domain

/**
 * Created by xiao on 2017/5/27.
 */


data class ForecastList(val city: String, val country: String,
                        val dailyForecast:List<Forecast>)

data class Forecast(val date: String, val description: String, val high: Int,
                    val low: Int,val iconUrl: String)