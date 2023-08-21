package com.varenie.homebar.database.bar

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BarDao {
    @Insert
    suspend fun insertAll(vararg barItems: BarEntity)

    @Query("SELECT * FROM BarEntity")
    suspend fun getAll(): List<BarEntity>
}