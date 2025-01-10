package com.ivoxavier.kaltracker

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


class App: Application() {
    override fun onCreate() {
        super.onCreate()
        val applicationContext = applicationContext.applicationInfo.processName
        println("Nome do Processo: $applicationContext")
    }
}