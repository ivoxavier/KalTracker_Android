package com.ivoxavier.kaltracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.ivoxavier.kaltracker.service.repository.Settings

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val appSettings = Settings(application)

    private val isCleanInstall = appSettings.isCleanInstall()

    fun isCleanInstall(): Boolean {
        return isCleanInstall
    }
}