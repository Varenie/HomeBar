package com.varenie.homebar.database.bar

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.varenie.homebar.model.AlcoType

@Entity
data class BarEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val title: String,
    val alcoType: AlcoType,
    val volume: Int
)