package com.ivoxavier.kaltracker.service.repository.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ivoxavier.kaltracker.service.repository.model.UserModel

@Dao
interface UserDAO {

    @Insert
    fun insert(user: UserModel): Long

    @Update
    fun update(user: UserModel): Long

    @Query("SELECT age FROM user")
    fun getAge() : Int

    @Query("SELECT sex_at_birth FROM user")
    fun getSex() : Int

    @Query("SELECT weight FROM user")
    fun getWeight() : Double

    @Query("SELECT height FROM user")
    fun getHeight() : Double

    @Query("SELECT activity FROM user")
    fun getActivity() : Int

    @Query("SELECT rec_cal FROM user")
    fun getRecCal() : Int

    @Query("DELETE FROM user")
    fun delete()

}