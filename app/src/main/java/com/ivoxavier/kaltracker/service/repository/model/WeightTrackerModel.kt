package com.ivoxavier.kaltracker.service.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ivoxavier.kaltracker.service.repository.constants.KalTrackerConstants


@Entity(tableName = KalTrackerConstants.DB.WEIGHT_TRACKER.TABLE_NAME)
class WeightTrackerModel {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = KalTrackerConstants.DB.WEIGHT_TRACKER.COLUMNS.ID)
    var id: Int = 0

    @ColumnInfo(name = KalTrackerConstants.DB.WEIGHT_TRACKER.COLUMNS.ID_USER)
    var id_user: Int = 0

    @ColumnInfo(name = KalTrackerConstants.DB.WEIGHT_TRACKER.COLUMNS.WEIGHT)
    var weight: Double = 0.0

    @ColumnInfo(name = KalTrackerConstants.DB.WEIGHT_TRACKER.COLUMNS.DATE)
    var date: String = ""
}