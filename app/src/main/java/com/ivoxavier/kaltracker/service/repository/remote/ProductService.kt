package com.ivoxavier.kaltracker.service.repository.remote

import com.ivoxavier.kaltracker.service.repository.constants.KalTrackerConstants
import com.ivoxavier.kaltracker.service.repository.model.ProductModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {
    @GET("${KalTrackerConstants.OPEN_FOODS_FACTS_API.ENDPOINTS.GET_PRODUCT}{barcode}.json")
    fun getProductInfo(@Path("barcode") barcode: String): Call<ProductModel>
}