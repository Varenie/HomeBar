package com.varenie.homebar.database.menu

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.varenie.homebar.model.AlcoType

@Entity
data class MenuEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val title: String,
    val ingredients: Map<AlcoType, Int> = mapOf(),
    val recipe: String,
    val description: String = "",
    val typeOfGlass: String = ""
)