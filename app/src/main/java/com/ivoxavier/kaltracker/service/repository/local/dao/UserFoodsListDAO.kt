package com.ivoxavier.kaltracker.service.repository.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ivoxavier.kaltracker.service.repository.model.UserFoodsListModel

@Dao
interface UserFoodsListDAO{

    @Insert
    fun insert(userFoodsList: UserFoodsListModel): Long

    @Query("SELECT EXISTS(SELECT * FROM user_foods_list WHERE name = :name)")
    fun isNewProduct(name: String): Boolean

}