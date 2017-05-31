package com.example.xiao.weather.command

import com.example.xiao.weather.domain.ForecastList
import com.example.xiao.weather.provider.ForecastProvider

/**
 * Created by xiao on 2017/5/27.
 */
class RequestForecastCommand(val zipCode:Long,val provider: ForecastProvider = ForecastProvider()): Command<ForecastList> {

    companion object {
        val DAYS = 7
    }

    override fun execute() = provider.requestByZipCode(zipCode, DAYS)
}