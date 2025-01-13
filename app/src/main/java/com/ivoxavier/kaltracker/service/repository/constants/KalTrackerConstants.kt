package com.ivoxavier.kaltracker.service.repository.constants

import androidx.compose.ui.graphics.Color

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

    //region API
    object OPEN_FOODS_FACTS_API{
        const val URL = "https://world.openfoodfacts.org/"
        object VERSION{
            const val V0 = "api/v0/"
        }
        object ENDPOINTS{
            const val GET_PRODUCT = "product/"
        }
    }
    //endregion

    //region HTTP
    object HTTP{
        const val SUCCESS = 200
    }

    //endregion

    //region AppSettings
    object APP_SETTINGS{
        const val APP_SETTINGS_NAME = "appsettings"
        const val IS_CLEAN_INSTALL = "is_clean_install"
        const val OPEN_FOODS_FACTS_API = "open_foods_facts_api"
    }
    //endregion

    //region QuickAdditionActivity
    object QUICK_ADDITION{
        const val PRODUCT_NAME = "product_name"
        const val PRODUCT_CALORIES = "product_calories"
        const val PRODUCT_MACROS = "product_macros"

        object NUTRISCORE{
            const val A = "a"
            const val B = "b"
            const val C = "c"
            const val D = "d"
            const val E = "e"

            object COLOR{
                val A = Color(0xFF007E33)
                val B = Color(0xFF7CB342)
                val C = Color(0xFFFFF176)
                val D = Color(0xFFFFA726)
                val E = Color(0xFFF44336)
            }
        }
    }
    //endregion

    //region IngestionConfigActivity
    object SIZE_PORTION{
        const val FULL_PORTION = 1.0 // 1/1
        const val HALF_PORTION = 0.5 // 1/2
        const val THIRD_PORTION = 0.33 // 1/3
        const val QUARTER_PORTION = 0.25 // 1/4
        const val FIFTH_PORTION = 0.2 // 1/5
        const val SIXTH_PORTION = 0.17 // 1/6
    }


    //endregion

}