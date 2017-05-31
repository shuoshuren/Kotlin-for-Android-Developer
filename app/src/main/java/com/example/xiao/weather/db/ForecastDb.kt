package com.example.xiao.weather.db

import com.example.xiao.weather.db.model.CityForecast
import com.example.xiao.weather.db.model.DayForecast
import com.example.xiao.weather.db.table.CityForecastTable
import com.example.xiao.weather.db.table.DayForecastTable
import com.example.xiao.weather.domain.ForecastList
import com.example.xiao.weather.provider.ForecastDataSource
import com.example.xiao.weather.utils.ext.clear
import com.example.xiao.weather.utils.ext.parseList
import com.example.xiao.weather.utils.ext.parseOpt
import com.example.xiao.weather.utils.ext.toVarargArray
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import java.util.*
import kotlin.NoSuchElementException


/**
 * Created by xiao on 2017/5/27.
 */
class ForecastDb(val dbHelper:ForecastDbHelper = ForecastDbHelper.instance,
        val dataMapper: DbDataMapper = DbDataMapper()):ForecastDataSource {

    override fun requestForecastByZipCode(zipCode: Long, date: Long) = dbHelper.use {
        val dailyRequest = "${DayForecastTable.CITY_ID} = ? AND ${DayForecastTable.DATE} >= ?"
        val dailyForecast = select(DayForecastTable.NAME)
                .whereSimple(dailyRequest, zipCode.toString(), date.toString())
                .parseList { DayForecast(HashMap(it)) }

        val city = select(CityForecastTable.NAME)
                .whereSimple("${CityForecastTable.ID} = ?", zipCode.toString())
                .parseOpt { CityForecast(HashMap(it), dailyForecast) }

        city?.let { dataMapper.convertToDomain(it) }
    }

    fun requestForecastByZipCode(zipCode:Long,date:Date) = dbHelper.use {

        val dailyRequest = "${DayForecastTable.CITY_ID} = {id} "+ " AND ${DayForecastTable.DATE} >= {date}"

        val dailyForecast = select(DayForecastTable.NAME)
                .whereArgs(dailyRequest,"id" to zipCode,"date" to date)
                .parseList { DayForecast(HashMap(it)) }


        val city = select(CityForecastTable.NAME)
                .whereSimple("${CityForecastTable.ID} = ?", zipCode.toString())
                .parseOpt { CityForecast(HashMap(it), dailyForecast) }

        if ( city != null) dataMapper.convertToDomain(city) else null

    }

    fun saveForecast(forecast:ForecastList) = dbHelper.use {
        clear(CityForecastTable.NAME)
        clear(DayForecastTable.NAME)
        with(dataMapper.convertFromDomain(forecast)){
            insert(CityForecastTable.NAME, *map.toVarargArray())
            dailyForecast.forEach {
                insert(DayForecastTable.NAME, *it.map.toVarargArray())
            }
        }
    }



}






