package com.example.xiao.weather.utils.ext

/**
 * Created by xiao on 2017/5/27.
 */

fun <K, V : Any> MutableMap<K, V?>.toVarargArray():
        Array<out Pair<K, V>> =  map({ Pair(it.key, it.value!!) }).toTypedArray()