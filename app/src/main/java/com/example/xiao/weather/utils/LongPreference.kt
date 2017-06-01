package com.example.xiao.weather.utils

import android.content.Context
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by xiao on 2017/6/1.
 */
class LongPreference(val context: Context,val name:String,val default:Long ):ReadWriteProperty<Any?,Long> {

    val prefs by lazy {
        context.getSharedPreferences("default",Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): Long {
        return prefs.getLong(name,default)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Long) {
        prefs.edit().putLong(name,value).apply()
    }
}