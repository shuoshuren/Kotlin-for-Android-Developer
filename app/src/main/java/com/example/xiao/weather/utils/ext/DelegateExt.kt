package com.example.xiao.weather.utils.ext

import android.content.Context
import com.example.xiao.weather.utils.LongPreference
import com.example.xiao.weather.utils.NotNullSingleValueVar
import com.example.xiao.weather.utils.Preference
import kotlin.properties.ReadWriteProperty

/**
 * Created by xiao on 2017/5/27.
 */


object DelegateExt {
    fun <T> notNullSingleValue(): ReadWriteProperty<Any?, T> = NotNullSingleValueVar()

    fun longPreference(context: Context,name:String,default:Long ) = LongPreference(context,name,default)

    fun <T> preference(context: Context,name:String,default: T) = Preference<T>(context, name, default)
}