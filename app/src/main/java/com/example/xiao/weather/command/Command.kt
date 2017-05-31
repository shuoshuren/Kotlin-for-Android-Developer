package com.example.xiao.weather.command

/**
 * Created by xiao on 2017/5/27.
 */
public interface Command<T> {

    fun execute():T
}