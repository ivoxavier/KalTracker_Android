package com.ivoxavier.kaltracker.service.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ivoxavier.kaltracker.service.repository.constants.KalTrackerConstants

@Entity(tableName = KalTrackerConstants.DB.WATER_TRACKER.TABLE_NAME)
class WaterTrackerModel {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name=KalTrackerConstants.DB.WATER_TRACKER.COLUMNS.ID)
    var id: Int = 0

    @ColumnInfo(name=KalTrackerConstants.DB.WATER_TRACKER.COLUMNS.ID_USER)
    var id_user: Int = 0

    @ColumnInfo(name=KalTrackerConstants.DB.WATER_TRACKER.COLUMNS.CUPS)
    var cups: Int = 0

    @ColumnInfo(name=KalTrackerConstants.DB.WATER_TRACKER.COLUMNS.DATE)
    var date: String = ""
}