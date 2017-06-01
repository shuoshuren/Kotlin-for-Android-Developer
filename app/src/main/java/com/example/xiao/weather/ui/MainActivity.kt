package com.example.xiao.weather.ui

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.example.xiao.weather.R
import com.example.xiao.weather.R.layout.activity_main
import com.example.xiao.weather.ui.adapter.ForecastListAdapter
import com.example.xiao.weather.utils.ext.DelegateExt
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity(),ToolbarManager {

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    val zipCode by DelegateExt.preference<Long>(this, SettingActivity.ZIP_CODE,
            SettingActivity.DEFAULT_ZIP)

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        initToolbar()

        forecastList.layoutManager = LinearLayoutManager(this)
        attachToScroll(forecastList)


    }

    override fun onResume() {
        super.onResume()
        loadForecast()
    }

    private fun loadForecast() = doAsync {
        val result = com.example.xiao.weather.command.RequestForecastCommand(zipCode).execute()
        android.util.Log.i("xc","result:"+result)
        uiThread {

            val adapter = ForecastListAdapter(result) {
                startActivity<DetailActivity>(DetailActivity.ID to it.id,
                        DetailActivity.CITY_NAME to result.city)
            }
            forecastList.adapter = adapter
            toolbarTitle = "${result.city} (${result.country})"
        }
    }


}
