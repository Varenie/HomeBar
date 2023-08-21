package com.varenie.homebar.viewmodels.bar

import com.varenie.homebar.database.bar.BarEntity
import com.varenie.homebar.model.AlcoType

sealed class BarEvent {
    object InitViewModel : BarEvent()
    data class SaveBarItem(val name: String, val type: AlcoType, val volume: Int): BarEvent()
}