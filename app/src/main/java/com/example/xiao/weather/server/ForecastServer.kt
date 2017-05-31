package com.example.xiao.weather.server

import com.example.xiao.weather.db.ForecastDb
import com.example.xiao.weather.domain.ForecastList
import com.example.xiao.weather.provider.ForecastDataSource

/**
 * Created by xiao on 2017/5/31.
 */
class ForecastServer(val dataManager: ServerDataManager = ServerDataManager(),
                     val forecastDb: ForecastDb = ForecastDb()): ForecastDataSource {


    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        val result = RequestForecastCommand(zipCode).execute()
        val converted = dataManager.convertToDomain(zipCode,result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode,date)



    }

}


