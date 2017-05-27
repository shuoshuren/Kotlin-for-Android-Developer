package com.example.xiao.weather.utils

import kotlin.properties.ReadWriteProperty

/**
 * Created by xiao on 2017/5/27.
 */


object DelegateExt {
    fun <T> notNullSingleValue():
            ReadWriteProperty<Any?, T> = NotNullSingleValueVar()
}