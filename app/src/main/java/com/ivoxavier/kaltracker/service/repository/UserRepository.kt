package com.ivoxavier.kaltracker.service.repository

import android.content.Context
import android.util.Log
import com.ivoxavier.kaltracker.service.repository.local.KalTrackerDatabase
import com.ivoxavier.kaltracker.service.repository.model.UserModel

class UserRepository(context: Context) {
    private val kalTrackerDatabase = KalTrackerDatabase.getDataBase(context).userDao()


    companion object {
        private lateinit var repository : UserRepository

        fun getInstance(context: Context): UserRepository {
            if(!Companion::repository.isInitialized) {
                repository = UserRepository(context)
            }
            return repository
        }
    }

    fun insert(user: UserModel):Boolean{
        return kalTrackerDatabase.insert(user) > 0
    }

    fun update(user: UserModel):Boolean{
        Log.d("UserRepository", "Updating user: $user") // Log the user object
        val rowsUpdated = kalTrackerDatabase.update(user)
        Log.d("UserRepository", "Rows updated: $rowsUpdated") // Log the result
        return rowsUpdated > 0
    }

    fun getRecommendedCalories(): Int{
        return kalTrackerDatabase.getRecCal() ?: 0
    }

}