package com.ivoxavier.kaltracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ivoxavier.kaltracker.service.repository.IngestionRepository
import com.ivoxavier.kaltracker.service.repository.model.IngestionModel

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

    private val _fat_100g = MutableLiveData<Double>()
    val fat_100g : LiveData<Double> = _fat_100g

    private val _carbo_100g = MutableLiveData<Double>()
    val carbo_100g : LiveData<Double> = _carbo_100g

    private val _protein_100g = MutableLiveData<Double>()
    val protein_100g : LiveData<Double> = _protein_100g

    private val _date = MutableLiveData<String>()
    val date : LiveData<String> = _date


    fun setProductName(newProductName: String){
        _productName.value = newProductName
    }

    fun setProductCalories(newProductCalories: Int){
        _calories.value = newProductCalories
    }

    fun setFat(newFat: Double  ){
        _fat_100g.value = newFat
    }

    fun setCarbo(newCarbo: Double  ){
        _carbo_100g.value = newCarbo
    }

    fun setProtein(newProtein: Double  ){
        _protein_100g.value = newProtein
    }


    fun save(ingestion: IngestionModel){
        repository.insert(ingestion)

    }


}