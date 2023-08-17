package com.varenie.homebar.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.varenie.homebar.database.bar.BarDao
import com.varenie.homebar.database.bar.BarEntity

@Database(entities = [BarEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun barDao(): BarDao
}