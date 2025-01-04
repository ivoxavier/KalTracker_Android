package com.ivoxavier.kaltracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.ivoxavier.kaltracker.service.repository.UserFoodsListRepository
import com.ivoxavier.kaltracker.service.repository.local.KalTrackerDatabase
import com.ivoxavier.kaltracker.service.repository.local.dao.UserFoodsListDAO
import com.ivoxavier.kaltracker.service.repository.model.UserFoodsListModel

class QuickListFoodsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = UserFoodsListRepository(application)

    private val userFoodsListDao : UserFoodsListDAO = KalTrackerDatabase.getDataBase(application).userFoodsListDao()

    //receives the meal category from homeactivity
    var mealCategory: Int = -1

    fun save(userFoodsList: UserFoodsListModel){
        repository.insert(userFoodsList)
    }

    fun isNewProduct(name: String): Boolean{
        return userFoodsListDao.isNewProduct(name)
    }
}