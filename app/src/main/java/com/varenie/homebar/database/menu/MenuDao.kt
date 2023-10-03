package com.varenie.homebar.database.menu

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MenuDao {

    @Insert
    suspend fun insertAll(vararg menuItems: MenuEntity)

    @Query("SELECT * FROM MenuEntity")
    suspend fun getAll(): List<MenuEntity>
}