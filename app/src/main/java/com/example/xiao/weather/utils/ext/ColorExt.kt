package com.example.xiao.weather.utils.ext

import android.content.Context
import android.support.v4.content.ContextCompat

/**
 * Created by xiao on 2017/5/31.
 */

public fun Context.color(res: Int): Int = ContextCompat.getColor(this, res)
