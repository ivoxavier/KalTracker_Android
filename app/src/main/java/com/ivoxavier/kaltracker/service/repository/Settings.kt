package com.ivoxavier.kaltracker.service.repository

import android.content.Context
import android.content.SharedPreferences

class Settings(context: Context) {

    private val appSettings: SharedPreferences = context.getSharedPreferences("appsettings", Context.MODE_PRIVATE)

    private val IS_CLEAN_INSTALL = "is_clean_install"

    private val IS_USER_CONFIGURED = "is_user_configured"

    fun isCleanInstall(): Boolean {
        return if (appSettings.contains(IS_CLEAN_INSTALL)) {
            false
        } else {

            appSettings.edit().putBoolean(IS_CLEAN_INSTALL, false).apply()
            true
        }
    }

    fun isUserConfigured(): Boolean {
        return if (appSettings.contains(IS_USER_CONFIGURED)) {
            false
        } else {
            appSettings.edit().putBoolean(IS_USER_CONFIGURED, false).apply()
            true
        }
    }
}