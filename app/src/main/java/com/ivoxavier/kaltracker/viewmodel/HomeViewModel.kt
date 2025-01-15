package com.ivoxavier.kaltracker.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ivoxavier.kaltracker.service.repository.IngestionRepository
import com.ivoxavier.kaltracker.service.repository.UserRepository
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application)  {
    private val userRepository = UserRepository(application)
    private val ingestionRepository = IngestionRepository(application)

    private val _recommendedCalories = MutableLiveData<Int>()
    val recommendedCalories: LiveData<Int> = _recommendedCalories

    private val _breakFastCalories = MutableLiveData<Int>()
    val breakFastCalories: LiveData<Int> = _breakFastCalories

    private val _lunchCalories = MutableLiveData<Int>()
    val lunchCalories: LiveData<Int> = _lunchCalories

    private val _dinnerCalories = MutableLiveData<Int>()
    val dinnerCalories: LiveData<Int> = _dinnerCalories

    private val _snackCalories = MutableLiveData<Int>()
    val snackCalories: LiveData<Int> = _snackCalories


    fun setRecommendedCalories() {
        val calories = userRepository.getRecommendedCalories() ?: 0
        _recommendedCalories.value = calories
    }


    fun setBreakFastCalories(){
        viewModelScope.launch {
            val calories = ingestionRepository.getBreakFastCalories() ?: 0
            _breakFastCalories.postValue(calories)
        }
    }

    fun setLunchCalories(){
        viewModelScope.launch {
            val calories = ingestionRepository.getLunchCalories() ?: 0
            _lunchCalories.postValue(calories)
        }
    }

    fun setDinnerCalories() {
        viewModelScope.launch {
            val calories = ingestionRepository.getDinnerCalories() ?: 0
            _dinnerCalories.postValue(calories)
        }
    }

    fun setSnackCalories() {
        viewModelScope.launch {
            val calories = ingestionRepository.getSnackCalories() ?: 0
            _snackCalories.postValue(calories)
        }
    }
}