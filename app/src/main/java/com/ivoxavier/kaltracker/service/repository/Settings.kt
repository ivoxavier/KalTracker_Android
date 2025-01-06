package com.ivoxavier.kaltracker.service.repository

import android.content.Context
import android.content.SharedPreferences
import com.ivoxavier.kaltracker.service.repository.constants.KalTrackerConstants
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class Settings(context: Context) {

    private val appSettings: SharedPreferences = context.getSharedPreferences(KalTrackerConstants.APP_SETTINGS.APP_SETTINGS_NAME, Context.MODE_PRIVATE)

    private val IS_CLEAN_INSTALL = KalTrackerConstants.APP_SETTINGS.IS_CLEAN_INSTALL
    private val OPEN_FOODS_FACTS_API = KalTrackerConstants.APP_SETTINGS.OPEN_FOODS_FACTS_API

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