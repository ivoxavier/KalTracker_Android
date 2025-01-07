package com.ivoxavier.kaltracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class ScanBarViewModel(application: Application) : AndroidViewModel(application) {
    //receives the meal category from homeactivity
    var mealCategory: Int = -1
}
