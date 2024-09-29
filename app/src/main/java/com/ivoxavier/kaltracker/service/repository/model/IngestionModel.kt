package com.ivoxavier.kaltracker.service.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ivoxavier.kaltracker.service.repository.constants.KalTrackerConstants


@Entity(tableName = KalTrackerConstants.DB.INGESTIONS.TABLE_NAME)
class IngestionModel {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = KalTrackerConstants.DB.INGESTIONS.COLUMNS.ID)
    var id: Int = 0

    @ColumnInfo(name = KalTrackerConstants.DB.INGESTIONS.COLUMNS.ID_USER)
    var id_user: Int = 0

    @ColumnInfo(name = KalTrackerConstants.DB.INGESTIONS.COLUMNS.NAME)
    var name: String = ""

    @ColumnInfo(name = KalTrackerConstants.DB.INGESTIONS.COLUMNS.NUTRISCORE)
    var nutriscore: String = ""

    @ColumnInfo(name = KalTrackerConstants.DB.INGESTIONS.COLUMNS.CAL)
    var cal: Int = 0

    @ColumnInfo(name = KalTrackerConstants.DB.INGESTIONS.COLUMNS.FAT)
    var fat: Double = 0.0

    @ColumnInfo(name = KalTrackerConstants.DB.INGESTIONS.COLUMNS.CARBO)
    var carbo: Double = 0.0

    @ColumnInfo(name = KalTrackerConstants.DB.INGESTIONS.COLUMNS.PROTEIN)
    var protein: Double = 0.0

    @ColumnInfo(name = KalTrackerConstants.DB.INGESTIONS.COLUMNS.DATE)
    var date: String = ""

    @ColumnInfo(name = KalTrackerConstants.DB.INGESTIONS.COLUMNS.MEAL)
    var meal: Int = 0

}