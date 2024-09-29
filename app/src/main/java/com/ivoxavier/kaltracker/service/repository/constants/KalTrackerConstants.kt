package com.ivoxavier.kaltracker.service.repository.constants

class KalTrackerConstants private constructor(){
    //region Database
    object DB{
        // region user table
        object USER{
            const val TABLE_NAME = "user"
            object COLUMNS{
                const val ID = "id"
                const val AGE = "age"
                const val SEX_AT_BIRTH = "sex_at_birth"
                const val WEIGHT = "weight"
                const val HEIGHT = "height"
                const val ACTIVITY = "activity"
                const val REC_CAL =  "rec_cal"
                const val AP_LO = "ap_lo"
                const val AP_HI = "ap_hi"
            }
        }
        //region ingestions table
        object INGESTIONS{
            const val TABLE_NAME = "ingestions"
            object COLUMNS{
                const val ID = "id"
                const val ID_USER = "id_user"
                const val NAME = "name"
                const val NUTRISCORE = "nutriscore"
                const val CAL = "cal"
                const val FAT = "fat"
                const val CARBO = "carbo"
                const val PROTEIN = "protein"
                const val DATE = "date"
                const val MEAL = "meal"
            }
        }
        //region user_foods_list
        object USER_FOODS_LIST {
            const val TABLE_NAME = "user_foods_list"
            object COLUMNS{
                const val ID = "id"
                const val ID_USER = "id_user"
                const val NAME = "name"
                const val NUTRISCORE = "nutriscore"
                const val CAL = "cal"
                const val FAT = "fat"
                const val CARBO = "carbo"
                const val PROTEIN = "protein"

            }
        }
        //region water_tracker table
        object WATER_TRACKER{
            const val TABLE_NAME = "water_tracker"
            object COLUMNS{
                const val ID = "id"
                const val ID_USER = "id_user"
                const val CUPS = "cups"
                const val DATE = "date"
            }

        }
        //region weight_tracker table
        object WEIGHT_TRACKER {
            const val TABLE_NAME = "weight_tracker"
            object COLUMNS{
                const val ID = "id"
                const val ID_USER = "id_user"
                const val WEIGHT = "weight"
                const val DATE = "date"
            }
        }
        //region notes table
        object NOTES {
            const val TABLE_NAME = "notes"
            object COLUMNS {
                const val ID = "id"
                const val ID_USER = "id_user"
                const val NOTE = "note"
                const val DATE = "date"
            }
        }
        // endregion
    }

    //endregion
}