package com.varenie.homebar.viewmodels.menu

import androidx.lifecycle.ViewModel
import com.varenie.homebar.database.AppDatabase
import com.varenie.homebar.view.navigation.AppNavigator
import com.varenie.homebar.view.navigation.Destination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    appDatabase: AppDatabase,
    private val appNavigator: AppNavigator
): ViewModel() {

    fun navigateToAdd() {
        appNavigator.tryNavigateTo(Destination.AddCocktail())
    }
}