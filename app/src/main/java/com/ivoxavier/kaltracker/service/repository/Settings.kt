package com.ivoxavier.kaltracker.service.repository

import android.content.Context
import android.content.SharedPreferences

class Settings(context: Context) {

    private val appSettings: SharedPreferences = context.getSharedPreferences("appsettings", Context.MODE_PRIVATE)

    private val IS_CLEAN_INSTALL = "is_clean_install"
    private val OPEN_FOODS_FACTS_API = "open_foods_facts_api"

    fun isCleanInstall(): Boolean {
        return if (appSettings.contains(IS_CLEAN_INSTALL)) {
            false
        } else {
            appSettings.edit().putBoolean(IS_CLEAN_INSTALL, false).apply()
            true
        }
    }

    fun isOpenFoodsFactsApiEnabled(): Boolean {
        return appSettings.getBoolean(OPEN_FOODS_FACTS_API, false)
    }
}