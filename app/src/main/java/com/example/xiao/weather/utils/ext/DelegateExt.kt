package com.example.xiao.weather.utils.ext

import kotlin.properties.ReadWriteProperty

/**
 * Created by xiao on 2017/5/27.
 */


object DelegateExt {
    fun <T> notNullSingleValue():
            kotlin.properties.ReadWriteProperty<Any?, T> = com.example.xiao.weather.utils.NotNullSingleValueVar()
}