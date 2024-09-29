package com.ivoxavier.kaltracker.service.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ivoxavier.kaltracker.service.repository.constants.KalTrackerConstants

@Entity(tableName = KalTrackerConstants.DB.USER.TABLE_NAME)
class UserModel {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name=KalTrackerConstants.DB.USER.COLUMNS.ID)
    var id: Int = 0

    @ColumnInfo(name=KalTrackerConstants.DB.USER.COLUMNS.AGE)
    var age: Int = 0

    @ColumnInfo(name=KalTrackerConstants.DB.USER.COLUMNS.SEX_AT_BIRTH)
    var sex_at_birth: String = ""

    @ColumnInfo(name=KalTrackerConstants.DB.USER.COLUMNS.WEIGHT)
    var weight: Double = 0.0

    @ColumnInfo(name=KalTrackerConstants.DB.USER.COLUMNS.HEIGHT)
    var height: Double = 0.0

    @ColumnInfo(name=KalTrackerConstants.DB.USER.COLUMNS.ACTIVITY)
    var activity: String = ""

    @ColumnInfo(name=KalTrackerConstants.DB.USER.COLUMNS.REC_CAL)
    var rec_cal: Int = 0

    @ColumnInfo(name=KalTrackerConstants.DB.USER.COLUMNS.AP_LO)
    var ap_lo: Int = 0

    @ColumnInfo(name=KalTrackerConstants.DB.USER.COLUMNS.AP_HI)
    var ap_hi: Int = 0
}