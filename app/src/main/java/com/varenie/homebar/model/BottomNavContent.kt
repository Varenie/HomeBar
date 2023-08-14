package com.varenie.homebar.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavContent(
    val title: String,
    @DrawableRes val iconId: Int
)