package com.ivoxavier.kaltracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.ivoxavier.kaltracker.service.repository.IngestionRepository

class QuickListFoodsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = IngestionRepository(application)


    //receives the meal category from homeactivity
    var mealCategory: Int = -1
}