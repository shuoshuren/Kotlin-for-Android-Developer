package com.example.xiao.weather

import com.example.xiao.weather.model.ForecastResult
import com.google.gson.Gson

/**
 * Created by xiao on 2017/5/27.
 */
public class ForecastRequest(var zipCode:String) {

    companion object{
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL:String = "$URL&APPID=$APP_ID&q="
    }

    fun exectue(): ForecastResult {
        var forecastJsonStr = java.net.URL(COMPLETE_URL+zipCode).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)


    }
}