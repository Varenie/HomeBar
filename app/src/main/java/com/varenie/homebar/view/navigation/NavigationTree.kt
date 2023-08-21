package com.varenie.homebar.view.navigation

import android.app.Activity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.varenie.homebar.view.bar.BarScreen
import com.varenie.homebar.view.cart.CartScreen
import com.varenie.homebar.view.menu.MenuScreen
import com.varenie.homebar.view.theme.HomeBarTheme
import com.varenie.homebar.view.theme.Purple40
import com.varenie.homebar.viewmodels.NavigationViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

@Composable
fun NavigationTree() {

    val navigationViewModel: NavigationViewModel = hiltViewModel()
    val navController = rememberNavController()

    NavigationEffects(
        navigationChannel = navigationViewModel.navigationChannel,
        navHostController = navController
    )

    HomeBarTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Purple40
        ) {
            NavHost(
                navController = navController,
                startDestination = Destination.BarScreen
            ) {
                composable(destination = Destination.BarScreen) {
                    println("test1")
                    BarScreen()
                }
                composable(destination = Destination.MenuScreen) {
                    println("test2")
                    MenuScreen()
                }
                composable(destination = Destination.CartScreen) {
                    println("test3")
                    CartScreen()
                }
            }
        }
    }
}

@Composable
fun NavigationEffects(
    navigationChannel: Channel<NavigationIntent>,
    navHostController: NavHostController
) {
    val activity = (LocalContext.current as? Activity)
    LaunchedEffect(activity, navHostController, navigationChannel) {
        navigationChannel.receiveAsFlow().collect { intent ->
            if (activity?.isFinishing == true) {
                return@collect
            }
            when (intent) {
                is NavigationIntent.NavigateBack -> {
                    if (intent.route != null) {
                        navHostController.popBackStack(intent.route, intent.inclusive)
                    } else {
                        navHostController.popBackStack()
                    }
                }
                is NavigationIntent.NavigateTo -> {
                    navHostController.navigate(intent.route) {
                        launchSingleTop = intent.isSingleTop
                        intent.popUpToRoute?.let { popUpToRoute ->
                            popUpTo(popUpToRoute) { inclusive = intent.inclusive }
                        }
                    }
                }
            }
        }
    }
}