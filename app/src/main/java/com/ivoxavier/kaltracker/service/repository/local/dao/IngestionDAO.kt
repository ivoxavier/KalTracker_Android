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

    @Query("SELECT SUM(cal) FROM ingestions WHERE meal = 0")
    fun getBreakFastCalories(): Int

    @Query("SELECT SUM(cal) FROM ingestions WHERE meal = 1")
    fun getLunchCalories(): Int

    @Query("SELECT SUM(cal) FROM ingestions WHERE meal = 2")
    fun getDinnerCalories(): Int

    @Query("SELECT SUM(cal) FROM ingestions WHERE meal = 3")
    fun getSnackCalories(): Int
}
