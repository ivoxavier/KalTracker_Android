package com.ivoxavier.kaltracker.viewmodel

import android.app.Application
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ivoxavier.kaltracker.service.repository.IngestionRepository
import com.ivoxavier.kaltracker.service.repository.Settings
import com.ivoxavier.kaltracker.service.repository.UserFoodsListRepository
import com.ivoxavier.kaltracker.service.repository.event.SingleLiveEvent
import com.ivoxavier.kaltracker.service.repository.listener.APIListener
import com.ivoxavier.kaltracker.service.repository.local.KalTrackerDatabase
import com.ivoxavier.kaltracker.service.repository.local.dao.UserDAO
import com.ivoxavier.kaltracker.service.repository.local.dao.UserFoodsListDAO
import com.ivoxavier.kaltracker.service.repository.model.Product
import com.ivoxavier.kaltracker.service.repository.model.ProductModel
import com.ivoxavier.kaltracker.service.repository.model.UserFoodsListModel
import kotlinx.coroutines.launch

class QuickListFoodsViewModel(application: Application) : AndroidViewModel(application) {
    private val userFoodsListRepository = UserFoodsListRepository(application)
    private val ingestionRepository = IngestionRepository(application)

    private val userFoodsListDao : UserFoodsListDAO = KalTrackerDatabase.getDataBase(application).userFoodsListDao()


    //need to fetch the id of user
    private val userDAO : UserDAO = KalTrackerDatabase.getDataBase(application).userDao()


    //receives the meal category from homeactivity
    var mealCategory: Int = -1


    private val _products = MutableLiveData<List<UserFoodsListModel>>()
    val products: LiveData<List<UserFoodsListModel>> = userFoodsListDao.getAll(1)

    fun save(userFoodsList: UserFoodsListModel){
        userFoodsListRepository.insert(userFoodsList)
    }

    fun isNewProduct(name: String): Boolean{
        return userFoodsListDao.isNewProduct(name)
    }

    private val _startActivityEvent = SingleLiveEvent<Product>()
    val startActivityEvent: LiveData<Product> = _startActivityEvent

    //region barcode

    var callback: BarcodeScannerCallback? = null

    private val _scannedProduct = MutableLiveData<Product>()
    val scannedProduct: LiveData<Product> = _scannedProduct

    private val _apiError = MutableLiveData<String>()
    val apiError: LiveData<String> = _apiError


    fun getProduct(barcode: String) {
        Log.d("GET_PRODUCT", "Barcode: $barcode")
        viewModelScope.launch {
            ingestionRepository.getProduct(barcode, object : APIListener<ProductModel> {
                override fun onSuccess(result: ProductModel) {
                    if (result.product != null) {
                        _scannedProduct.value = result.product!!
                        _startActivityEvent.value = result.product!!
                    } else {
                        _apiError.value = "Produto não encontrado."
                    }
                }

                override fun onFailure(message: String) {
                    _apiError.value = message
                }
            })
        }
    }


    interface BarcodeScannerCallback {
        fun onBarcodeScanned(barcode: String)
    }

    fun setBarcodeScannerCallback(callback: BarcodeScannerCallback) {
        this.callback = callback
    }



    /*fun onBarcodeScanned(barcode: String) {
        _scannedProduct.value = barcode
    }*/

    //endregion

}