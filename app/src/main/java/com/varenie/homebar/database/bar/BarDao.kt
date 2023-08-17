package com.varenie.homebar.database.bar

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BarDao {
    @Insert
    fun insertAll(vararg barItems: BarEntity)

    @Query("SELECT * FROM BarEntity")
    fun getAll(): List<BarEntity>
}