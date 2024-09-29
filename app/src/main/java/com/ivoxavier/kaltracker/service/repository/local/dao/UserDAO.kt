package com.ivoxavier.kaltracker.service.repository.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ivoxavier.kaltracker.service.repository.model.UserModel

@Dao
interface UserDAO {

    @Insert
    fun save(list: List<UserModel>)

    @Query("SELECT age FROM user")
    fun getAge() : Int

    @Query("DELETE FROM user")
    fun delete()

}