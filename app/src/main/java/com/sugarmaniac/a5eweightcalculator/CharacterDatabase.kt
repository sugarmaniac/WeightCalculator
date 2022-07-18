package com.sugarmaniac.a5eweightcalculator

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CharacterEntitity::class], version = 1, exportSchema = false)
abstract class CharacterDatabase : RoomDatabase() {

    abstract fun characterDao() : CharacterDao

    companion object{
        @Volatile
        private var Instance: CharacterDatabase? = null

        fun getDatabase(context: Context): CharacterDatabase {
            val tempInstance = Instance
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = androidx.room.Room.databaseBuilder(
                    context.applicationContext,
                    com.sugarmaniac.a5eweightcalculator.CharacterDatabase::class.java,
                    "character_database"
                ).build()
                Instance = instance
                return instance
            }
        }
    }


}