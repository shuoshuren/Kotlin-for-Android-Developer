package com.example.xiao.weather.provider

import com.example.xiao.weather.db.ForecastDb
import com.example.xiao.weather.domain.ForecastList
import com.example.xiao.weather.server.ForecastServer

/**
 * Created by xiao on 2017/5/31.
 */
class ForecastProvider(val source: List<ForecastDataSource> = ForecastProvider.SOURCES){
    companion object{
        val DAY_IN_MILLES = 1000*60*60*24
        val SOURCES = listOf<ForecastDataSource>(ForecastDb(), ForecastServer())
    }

    fun requestByZipCode(zipCode: Long,days: Int):ForecastList{
        return source.firstResult { requestSource(it,days,zipCode) }
    }

    private fun todayTimeSpan() = System.currentTimeMillis()/ DAY_IN_MILLES

    private fun requestSource(source:ForecastDataSource,days:Int,zipCode:Long):ForecastList?{
        val res = source.requestForecastByZipCode(zipCode,todayTimeSpan())
        return if( res != null && res.dailyForecast.size >= days) res else null
    }

    inline fun <T,R:Any> Iterable<T>.firstResult(predicate:(T)->R?):R{
        for (element in this){
            val result = predicate(element)
            if (result!=null) return result
        }
        throw NoSuchElementException("No element matching predicate was found.")
    }

}



