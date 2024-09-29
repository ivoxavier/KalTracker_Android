package com.ivoxavier.kaltracker.service.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ivoxavier.kaltracker.service.repository.local.dao.IngestionDAO
import com.ivoxavier.kaltracker.service.repository.local.dao.UserDAO
import com.ivoxavier.kaltracker.service.repository.model.IngestionModel
import com.ivoxavier.kaltracker.service.repository.model.UserModel

@Database(entities = [UserModel::class,
                     IngestionModel::class], version = 1 )
abstract class KalTrackerDatabase: RoomDatabase() {

    abstract fun userDao(): UserDAO
    abstract fun ingestionsDao(): IngestionDAO

    companion object{
        private lateinit var INSTANCE: KalTrackerDatabase

        fun getDataBase(context: Context): KalTrackerDatabase{
            if(!::INSTANCE.isInitialized) {
                //garante que so executa uma instancia por vez
                synchronized(KalTrackerDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context, KalTrackerDatabase::class.java, "kaltrackerdb"
                    ).allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }
    }
}