package com.example.xiao.weather.ui

import android.support.v7.graphics.drawable.DrawerArrowDrawable
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.example.xiao.weather.App
import com.example.xiao.weather.R
import com.example.xiao.weather.utils.ext.slideEnter
import com.example.xiao.weather.utils.ext.slideExit
import org.jetbrains.anko.toast

/**
 * Created by xiao on 2017/6/1.
 */
interface ToolbarManager {
    val toolbar:Toolbar
    var toolbarTitle:String
    get() = toolbar.title.toString()
    set(value) {
        toolbar.title = value
    }

    fun initToolbar(){
        toolbar.inflateMenu(R.menu.menu_main)
        toolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.action_setting-> App.instance.toast("setting")
                else -> App.instance.toast("UnKnow option")

            }
            true
        }
    }

    fun enableHomeAsUp(up:()->Unit){
        toolbar.navigationIcon = createUpDrawable()
        toolbar.setNavigationOnClickListener { up() }
    }

    fun  createUpDrawable()= with(DrawerArrowDrawable(toolbar.context)){
        progress = 1.0f
        this
    }

    /**
     * 允许toolbar可以attached到一个scroll上面，并且根据scroll的方向来执行动画。当往下滚动时toolbar会消失 ，往上滚动toolbar会再次显示
     */
    fun attachToScroll(recyclerView: RecyclerView){
        recyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                if(dy>0) toolbar.slideExit() else toolbar.slideEnter()
            }
        })
    }
}