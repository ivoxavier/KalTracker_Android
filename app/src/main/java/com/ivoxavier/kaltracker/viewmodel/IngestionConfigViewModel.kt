package com.ivoxavier.kaltracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ivoxavier.kaltracker.service.repository.IngestionRepository
import com.ivoxavier.kaltracker.service.repository.UserFoodsListRepository
import com.ivoxavier.kaltracker.service.repository.model.Product
import com.ivoxavier.kaltracker.service.repository.model.UserFoodsListModel

class IngestionConfigViewModel(application: Application) : AndroidViewModel(application) {
    private val userFoodsListRepository = UserFoodsListRepository(application)
    private val ingestionRepository = IngestionRepository(application)


    private val _product = MutableLiveData<Product?>()
    val product: LiveData<Product?> = _product

    fun setProduct(product: Product?) {
        _product.value = product
    }


    private val _userFoodsList = MutableLiveData<List<UserFoodsListModel>?>()
    val userFoodsList: LiveData<List<UserFoodsListModel>?> = _userFoodsList

    fun setUserFoodsList(list: List<UserFoodsListModel>?) {
        _userFoodsList.value = list
    }


    private val _productIndex = MutableLiveData<Int>()
    val productIndex: LiveData<Int> = _productIndex

    fun setProductIndex(index: Int) {
        _productIndex.value = index
    }

    var mealCategory: Int = -1

}