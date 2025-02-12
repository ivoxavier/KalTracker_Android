package com.ivoxavier.kaltracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ivoxavier.kaltracker.service.repository.IngestionRepository
import com.ivoxavier.kaltracker.service.repository.local.KalTrackerDatabase
import com.ivoxavier.kaltracker.service.repository.local.dao.UserDAO
import com.ivoxavier.kaltracker.service.repository.model.IngestionModel

class QuickAdditionViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = IngestionRepository(application)

    private val viewModel = HomeViewModel(application)

    //need to fetch the id of user
    private val userDAO : UserDAO = KalTrackerDatabase.getDataBase(application).userDao()


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

    fun setNutriscore(newNutriscore: String){
        _nutriscore.value = newNutriscore
    }

    fun getUserId(): Int? {
        return userDAO.getId()
    }

    fun save(ingestion: IngestionModel){
        repository.insert(ingestion)
        viewModel.setBreakFastCalories()
        viewModel.setLunchCalories()
        viewModel.setDinnerCalories()
        viewModel.setSnackCalories()

    }


}