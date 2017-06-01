package com.example.xiao.weather.utils.ext

import android.view.View

/**
 * Created by xiao on 2017/6/1.
 */

fun View.slideExit(){
    if(translationY == 0f) animate().translationY(-height.toFloat())

}

fun View.slideEnter(){
    if(translationY<0f) animate().translationY(0f)

}
