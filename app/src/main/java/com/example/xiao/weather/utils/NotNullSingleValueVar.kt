package com.example.xiao.weather.utils

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * 一个notNull的委托
 * Getter函数 如果已经被初始化，则会返回一个值，否则会抛异常。
 * Setter函数 如果仍然是null，则赋值，否则会抛异常
 *
 * Created by xiao on 2017/5/27.
 */
class NotNullSingleValueVar<T>():ReadWriteProperty<Any?,T> {

    private var value:T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {

        if(this.value ==null){

            throw IllegalStateException("not init!!")
        }
        return this.value as T

    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        if(this.value == null){
            this.value = value
        }else{
            throw java.lang.IllegalStateException("already init")
        }

    }



}