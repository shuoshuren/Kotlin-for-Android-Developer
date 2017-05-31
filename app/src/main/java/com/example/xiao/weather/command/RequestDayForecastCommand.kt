package com.example.xiao.weather.command

import com.example.xiao.weather.domain.Forecast
import com.example.xiao.weather.provider.ForecastProvider

/**
 * Created by xiao on 2017/5/31.
 */
class RequestDayForecastCommand(val id:Long,
                                val provider:ForecastProvider = ForecastProvider()):
                                Command<Forecast>{

    override fun execute(): Forecast {
        return provider.requestForecast(id)
    }
}