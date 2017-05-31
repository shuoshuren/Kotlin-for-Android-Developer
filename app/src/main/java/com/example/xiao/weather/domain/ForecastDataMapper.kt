package com.example.xiao.weather.domain

import com.example.xiao.weather.model.ForecastResult
import java.text.DateFormat
import java.util.*
import com.example.xiao.weather.domain.Forecast as ModelForecast

/**
 * Created by xiao on 2017/5/27.
 */

public class ForecastDataMapper {

    fun convertFromDataModule(forecast:ForecastResult):ForecastList{
        return ForecastList(forecast.city.id,forecast.city.name,forecast.city.country,convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<com.example.xiao.weather.model.ModelForecast>): List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }

    }

    private fun convertForecastItemToDomain(forecast: com.example.xiao.weather.model.ModelForecast): ModelForecast {

        return ModelForecast(-1,convertDate(forecast.dt),forecast.weather[0].description,
                forecast.temp.max.toInt(),forecast.temp.min.toInt(),generateIconUrl(forecast.weather[0].icon))
    }

    private fun generateIconUrl(icon: String): String = "http://openweathermap.org/img/w/$icon.png"

    private fun convertDate(date: Long): String {

        var df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date*1000)
    }
}
