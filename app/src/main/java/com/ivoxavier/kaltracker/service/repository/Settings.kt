package com.ivoxavier.kaltracker.service.repository

import android.content.Context
import android.content.SharedPreferences

class Settings(context: Context) {
    private val app_settings: SharedPreferences = context.getSharedPreferences("appsettings", Context.MODE_PRIVATE)

    private val IS_CLEAN_INSTALL = "is_clean_install"

    fun isCleanInstall(): Boolean {
        // Verifica se a chave já existe
        return if (app_settings.contains(IS_CLEAN_INSTALL)) {
            false // Se a chave existe
        } else {
            // Se a chave não existe
            app_settings.edit().putBoolean(IS_CLEAN_INSTALL, false).apply()
            true
        }
    }
}