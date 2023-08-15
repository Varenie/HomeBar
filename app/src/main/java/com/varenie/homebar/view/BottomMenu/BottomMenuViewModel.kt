package com.varenie.homebar.view.BottomMenu

import androidx.lifecycle.ViewModel
import com.varenie.homebar.view.navigation.AppNavigator
import com.varenie.homebar.view.navigation.Destination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BottomMenuViewModel @Inject constructor(
    private val appNavigator: AppNavigator
): ViewModel() {
    fun onNavigateToMenu() { appNavigator.tryNavigateTo(Destination.MenuScreen())}
    fun onNavigateToBar() { appNavigator.tryNavigateTo(Destination.BarScreen())}
    fun onNavigateToCart() { appNavigator.tryNavigateTo(Destination.CartScreen())}
}