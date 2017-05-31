package com.example.xiao.weather.utils.ext

import java.text.DateFormat
import java.util.*

/**
 * Created by xiao on 2017/5/31.
 */


fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM):String{
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}