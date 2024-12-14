package com.ivoxavier.kaltracker.viewmodel

import android.app.Application
import android.content.pm.PackageManager
import androidx.lifecycle.AndroidViewModel
import com.ivoxavier.kaltracker.R

class MenuViewModel(application: Application): AndroidViewModel(application) {
    private val appVersion: String = try {
        val packageInfo = application.packageManager.getPackageInfo(application.packageName, 0)
        packageInfo.versionName
    } catch (e: PackageManager.NameNotFoundException) {
        R.string.menu_item_not_available.toString()
    }

    fun getAppVersion(): String {
        return appVersion
    }

}