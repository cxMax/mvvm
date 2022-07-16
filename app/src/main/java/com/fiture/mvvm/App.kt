package com.fiture.mvvm

import android.app.Application
import android.content.Context
import com.biubiu.eventbus.EventBusInitializer
import com.fiture.mvvm.utils.log.LogInit
import javax.inject.Inject

/**
 *
 * Created by caixi on 2022/6/21.
 */
open class App : Application() {

    @Inject lateinit var logInit: LogInit
    companion object {
        lateinit var context: Context

    }

    override fun onCreate() {
        super.onCreate()
        logInit.init(this)
        context = this
        EventBusInitializer.init(this)
    }
}