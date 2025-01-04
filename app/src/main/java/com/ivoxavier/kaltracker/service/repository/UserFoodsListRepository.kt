package com.ivoxavier.kaltracker.service.repository

import android.content.Context
import com.ivoxavier.kaltracker.service.repository.local.KalTrackerDatabase
import com.ivoxavier.kaltracker.service.repository.model.UserFoodsListModel

class UserFoodsListRepository(context: Context) {

    private val kalTrackerDatabase = KalTrackerDatabase.getDataBase(context).userFoodsListDao()

    companion object{
        private lateinit var repository : UserFoodsListRepository

        fun getInstance(context: Context): UserFoodsListRepository{
            if(!Companion::repository.isInitialized) {
                repository = UserFoodsListRepository(context)
            }
            return repository
        }
    }

    fun insert(userFoodsList: UserFoodsListModel):Boolean{
        return kalTrackerDatabase.insert(userFoodsList) > 0
    }
}