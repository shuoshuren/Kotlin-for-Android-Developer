package com.example.xiao.weather.db.model

/**
 * Created by xiao on 2017/5/27.
 */
class CityForecast(val map:MutableMap<String,Any?>,val dailyForecast:List<DayForecast>) {

    var _id :Long by map
    var city:String by map
    var country:String by map

    constructor(id:Long,city:String,country:String,dailyForecast:List<DayForecast>) : this(HashMap<String,Any?>(),dailyForecast){
        this._id = id
        this.city = city
        this.country = country
    }

}


