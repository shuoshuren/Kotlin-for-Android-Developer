package com.example.xiao.weather

import android.app.Application
import com.example.xiao.weather.utils.ext.DelegateExt

/**
 * Created by xiao on 2017/5/27.
 */
class App:Application() {

    companion object{
        var instance:App by DelegateExt.notNullSingleValue<App>()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this


    }


}