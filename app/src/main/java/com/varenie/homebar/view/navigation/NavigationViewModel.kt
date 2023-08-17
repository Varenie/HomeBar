package com.varenie.homebar.view.navigation

import androidx.lifecycle.ViewModel
import com.varenie.homebar.view.navigation.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NavigationViewModel @Inject constructor(
    appNavigator: AppNavigator
): ViewModel() {
    val navigationChannel = appNavigator.navigationChannel
}