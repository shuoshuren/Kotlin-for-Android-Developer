package com.example.xiao.weather.model

/**
 * Created by xiao on 2017/5/31.
 */
data class ModelForecast(val dt: Long, val temp: Temperature, val pressure: Float, val humidity: Int,
                         val weather: List<Weather>, val speed: Float, val deg: Int, val clouds: Int, val rain: Float)