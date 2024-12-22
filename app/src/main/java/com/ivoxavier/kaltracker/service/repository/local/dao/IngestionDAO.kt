package com.ivoxavier.kaltracker.service.repository.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ivoxavier.kaltracker.service.repository.model.IngestionModel

@Dao
interface IngestionDAO {

    @Insert
    fun insert(ingestion: IngestionModel): Long

    @Query("SELECT * FROM ingestions")
    fun getAll(): List<IngestionModel>

}