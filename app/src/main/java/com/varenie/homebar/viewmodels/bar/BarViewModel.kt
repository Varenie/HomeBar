package com.varenie.homebar.viewmodels.bar

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.varenie.homebar.database.AppDatabase
import com.varenie.homebar.database.bar.BarEntity
import com.varenie.homebar.model.AlcoType
import com.varenie.homebar.view.navigation.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BarViewModel @Inject constructor(
    private val appNavigator: AppNavigator,
    private val database: AppDatabase
): ViewModel() {
    private val _barItems: MutableStateFlow<ArrayList<BarEntity>> = MutableStateFlow(arrayListOf())
    val barItems: StateFlow<List<BarEntity>> = _barItems
    val confirmVisible: MutableState<Boolean> = mutableStateOf(false)
    fun onEvent(event: BarEvent) {
        when(event) {
            is BarEvent.InitViewModel -> initList()
            is BarEvent.SaveBarItem -> saveItem(event.name, event.type, event.volume)
        }
    }

    private  fun initList() = viewModelScope.launch {
        _barItems.value = ArrayList(database.barDao().getAll())
    }


    private fun saveItem(name: String, type: AlcoType, volume: Int)  {
        if (checkInput(name, type)) {
            val item = BarEntity(
                title = name,
                alcoType = type,
                volume = volume
            )
            _barItems.value.add(item)
            viewModelScope.launch {
                database.barDao().insertAll(item)
            }
        }
    }
    private fun checkInput(
        name: String,
        type: AlcoType,
//        volume: Int
    ): Boolean {
        val result = name.isNotBlank() && type != AlcoType.NO_SELECTION
        confirmVisible.value = result
        return result
    }
}