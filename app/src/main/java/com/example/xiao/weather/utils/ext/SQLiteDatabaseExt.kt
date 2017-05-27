package com.example.xiao.weather.utils.ext

import android.database.sqlite.SQLiteDatabase

/**
 * Created by xiao on 2017/5/27.
 */

fun android.database.sqlite.SQLiteDatabase.clear(tableName:String){

    execSQL("delete from $tableName")

}
