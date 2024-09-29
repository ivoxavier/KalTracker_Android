package com.ivoxavier.kaltracker.service.repository.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ivoxavier.kaltracker.service.repository.constants.KalTrackerConstants

@Entity(tableName = KalTrackerConstants.DB.NOTES.TABLE_NAME)
class NotesModel {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name=KalTrackerConstants.DB.NOTES.COLUMNS.ID)
    var id: Int = 0

    @ColumnInfo(name=KalTrackerConstants.DB.NOTES.COLUMNS.ID_USER)
    var id_user: Int = 0

    @ColumnInfo(name=KalTrackerConstants.DB.NOTES.COLUMNS.NOTE)
    var note: String = ""

    @ColumnInfo(name=KalTrackerConstants.DB.WATER_TRACKER.COLUMNS.DATE)
    var date: String = ""
}