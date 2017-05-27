package com.example.xiao.weather.utils.ext

import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.SelectQueryBuilder

/**
 * Created by xiao on 2017/5/27.
 */


public fun <T : Any> org.jetbrains.anko.db.SelectQueryBuilder.parseList(parser: (Map<String, Any?>) -> T): List<T> {
    return parseList(object : org.jetbrains.anko.db.MapRowParser<T> {
        override fun parseRow(columns: Map<String, Any?>): T = parser(columns)
    })
}

public fun <T : Any> org.jetbrains.anko.db.SelectQueryBuilder.parseOpt(parser: (Map<String, Any?>) -> T): T? {
    return parseOpt(object : org.jetbrains.anko.db.MapRowParser<T> {
        override fun parseRow(columns: Map<String, Any?>): T = parser(columns)
    })
}


