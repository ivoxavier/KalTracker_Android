package com.ivoxavier.kaltracker.service.repository

import android.content.Context
import android.content.SharedPreferences

class Settings(context: Context) {

    private val app_settings: SharedPreferences = context.getSharedPreferences("appsettings", Context.MODE_PRIVATE)

    private val IS_CLEAN_INSTALL = "is_clean_install"

    fun isCleanInstall(): Boolean {
        return if (app_settings.contains(IS_CLEAN_INSTALL)) {
            false
        } else {
            //esta linha daqui
            ///app_settings.edit().putBoolean(IS_CLEAN_INSTALL, false).apply()
            true
        }
    }
}