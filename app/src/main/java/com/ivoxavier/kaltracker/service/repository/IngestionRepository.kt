package com.ivoxavier.kaltracker.service.repository

import android.content.Context
import com.ivoxavier.kaltracker.service.repository.local.KalTrackerDatabase
import com.ivoxavier.kaltracker.service.repository.model.IngestionModel

class IngestionRepository(context: Context) {
    private val kalTrackerDatabase = KalTrackerDatabase.getDataBase(context).ingestionsDao()

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

}