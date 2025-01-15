package com.ivoxavier.kaltracker.service.repository

import android.app.Application
import android.content.Context
import android.util.Log
import com.ivoxavier.kaltracker.R
import com.ivoxavier.kaltracker.service.repository.listener.APIListener
import com.ivoxavier.kaltracker.service.repository.local.KalTrackerDatabase
import com.ivoxavier.kaltracker.service.repository.model.IngestionModel
import com.ivoxavier.kaltracker.service.repository.model.ProductModel
import com.ivoxavier.kaltracker.service.repository.remote.ProductService
import com.ivoxavier.kaltracker.service.repository.remote.RetrofitClient
import com.ivoxavier.kaltracker.viewmodel.HomeViewModel

class IngestionRepository(context: Context): BaseRepository(context) {
    private val kalTrackerDatabase = KalTrackerDatabase.getDataBase(context).ingestionsDao()
    private val remote = RetrofitClient.getService(ProductService::class.java)

    companion object{
        private lateinit var repository : IngestionRepository

        fun getInstance(context: Context): IngestionRepository{
            if(!Companion::repository.isInitialized) {
                repository = IngestionRepository(context)
            }
            return repository
        }
    }

    fun insert(ingestion: IngestionModel):Boolean{
        return kalTrackerDatabase.insert(ingestion) > 0
    }

    fun getBreakFastCalories(): Int{
        return kalTrackerDatabase.getBreakFastCalories()
    }

    fun getLunchCalories(): Int{
        return kalTrackerDatabase.getLunchCalories()
    }

    fun getDinnerCalories(): Int{
        return kalTrackerDatabase.getDinnerCalories()
    }

    fun getSnackCalories(): Int{
        return kalTrackerDatabase.getSnackCalories()
    }

    fun getProduct(barcode:String, listener: APIListener<ProductModel>){
        if(!isConnectionAvailable()){
            listener.onFailure(context.getString(R.string.global_string_unexpected_error))
            return
        }
        try{
            executeCall(remote.getProductInfo(barcode), listener)
        }catch(e: Exception){
            listener.onFailure("Error: $e")
        }
    }

}