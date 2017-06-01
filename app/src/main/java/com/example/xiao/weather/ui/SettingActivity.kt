package com.example.xiao.weather.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.example.xiao.weather.R
import com.example.xiao.weather.utils.ext.DelegateExt
import kotlinx.android.synthetic.main.activity_setting.*
import kotlinx.android.synthetic.main.toolbar.*

class SettingActivity : AppCompatActivity() {

    companion object{
        val ZIP_CODE = "zipCode"
        val DEFAULT_ZIP = 94043L
    }

    var zipCode by DelegateExt.preference<Long>(this, ZIP_CODE, DEFAULT_ZIP)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        cityCode.setText(zipCode.toString())
    }

    override fun onOptionsItemSelected(item: MenuItem?) = when(item?.itemId){
        android.R.id.home->{ onBackPressed(); true}
        else->false
    }

    override fun onBackPressed() {
        super.onBackPressed()

        zipCode = cityCode.text.toString().toLong()

    }
}
