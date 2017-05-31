package com.example.xiao.weather.server

import com.example.xiao.weather.command.Command
import com.example.xiao.weather.domain.ForecastList
import com.example.xiao.weather.provider.ForecastProvider

/**
 * Created by xiao on 2017/5/31.
 */

class RequestForecastCommand(val zipCode:Long,val forecastProvider: ForecastProvider = ForecastProvider()): Command<ForecastList> {

    companion object{
        val DAYS = 7
    }

    override fun execute(): ForecastList {
        return forecastProvider.requestByZipCode(zipCode,DAYS)
    }

}
