package com.example.xiao.weather.domain

import com.example.xiao.weather.ForecastRequest

/**
 * Created by xiao on 2017/5/27.
 */
class RequestForecastCommand(private val zipCode:String):Command<ForecastList> {

    override fun execute(): ForecastList {
        var request = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModule(request.exectue())

    }
}