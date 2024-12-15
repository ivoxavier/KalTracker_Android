package com.ivoxavier.kaltracker.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ivoxavier.kaltracker.service.repository.UserRepository

class HomeViewModel(application: Application) : AndroidViewModel(application)  {
    private val repository = UserRepository(application)

    private val _recommendedCalories = MutableLiveData<Int>()
    val recommendedCalories: LiveData<Int> = _recommendedCalories


    fun setRecommendedCalories() {
        val calories = repository.getRecommendedCalories() ?: 0
        _recommendedCalories.value = calories
    }

}