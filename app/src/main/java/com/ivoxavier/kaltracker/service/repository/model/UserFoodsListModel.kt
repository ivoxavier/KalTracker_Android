package com.ivoxavier.kaltracker.service.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ivoxavier.kaltracker.service.repository.constants.KalTrackerConstants


@Entity(tableName = KalTrackerConstants.DB.USER_FOODS_LIST.TABLE_NAME)
class UserFoodsListModel {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name=KalTrackerConstants.DB.USER_FOODS_LIST.COLUMNS.ID)
    var id: Int = 0

    @ColumnInfo(name=KalTrackerConstants.DB.USER_FOODS_LIST.COLUMNS.ID_USER)
    var id_user: Int = 0

    @ColumnInfo(name=KalTrackerConstants.DB.USER_FOODS_LIST.COLUMNS.NAME)
    var name: String = ""

    @ColumnInfo(name=KalTrackerConstants.DB.USER_FOODS_LIST.COLUMNS.NUTRISCORE)
    var nutriscore: String = ""

    @ColumnInfo(name=KalTrackerConstants.DB.USER_FOODS_LIST.COLUMNS.CAL)
    var cal: Int = 0

    @ColumnInfo(name=KalTrackerConstants.DB.USER_FOODS_LIST.COLUMNS.FAT)
    var fat: Double = 0.0

    @ColumnInfo(name=KalTrackerConstants.DB.USER_FOODS_LIST.COLUMNS.CARBO)
    var carbo: Double = 0.0

    @ColumnInfo(name=KalTrackerConstants.DB.USER_FOODS_LIST.COLUMNS.PROTEIN)
    var protein: Double = 0.0
}