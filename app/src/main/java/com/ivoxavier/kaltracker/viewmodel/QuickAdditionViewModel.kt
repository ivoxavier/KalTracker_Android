package com.ivoxavier.kaltracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ivoxavier.kaltracker.service.repository.IngestionRepository

class QuickAdditionViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = IngestionRepository(application)

    //receives the meal category from quicklistfoodsactivity
    var mealCategory: Int = -1

    private val _productName = MutableLiveData<String>()
    val productName : LiveData<String> = _productName

    private val _calories = MutableLiveData<Int>()
    val calories : LiveData<Int> = _calories

    private val _nutriscore = MutableLiveData<String>()
    val nutriscore : LiveData<String> = _nutriscore


    fun setProductName(newProductName: String){
        _productName.value = newProductName
    }

    fun setProductCalories(newProductCalories: Int){
        _calories.value = newProductCalories
    }
}