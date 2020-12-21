package com.example.appdetragos

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appdetragos.data.DrinkEntity
import com.example.appdetragos.domain.TragosDao

@Database(entities = [DrinkEntity::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun tragosDao(): TragosDao

    companion object {

        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            val INSTANCE = INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                "user_database"
            ).build()

            return INSTANCE

        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

}