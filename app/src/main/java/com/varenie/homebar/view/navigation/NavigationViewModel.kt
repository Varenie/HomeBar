package com.varenie.homebar.view.navigation

import androidx.lifecycle.ViewModel
import com.varenie.homebar.view.navigation.AppNavigator

class NavigationViewModel (
    appNavigator: AppNavigator
): ViewModel() {
    val navigationChannel = appNavigator.navigationChannel
}