package com.example.xiao.weather.utils

import android.content.Context
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by xiao on 2017/6/1.
 */
class Preference<T>(val context: Context,val name:String,val default:T ):ReadWriteProperty<Any?,T> {

    val prefs by lazy {
        context.getSharedPreferences("default",Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return findPreference(name,default)
    }



    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putPreference(name,value)
    }

    private fun<T> findPreference(name: String, default: T): T = with(prefs){
        var res:Any = when(default){
            is String-> getString(name,default)
            is Long -> getLong(name,default)
            is Boolean ->getBoolean(name,default)
            is Float -> getFloat(name,default)
            is Int -> getInt(name,default)
            else -> throw IllegalArgumentException("This type can be saved into Preferences")

        }
        res as T
    }

    private fun<T> putPreference(name: String, value: T) = with(prefs.edit()){
        when(value){
            is String -> putString(name,value)
            is Long -> putLong(name,value)
            is Boolean -> putBoolean(name,value)
            is Float -> putFloat(name,value)
            is Int -> putInt(name,value)
            else -> throw IllegalArgumentException("This type can be saved into Preferences")
        }.apply()
    }
}