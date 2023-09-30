package com.varenie.homebar.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.varenie.homebar.view.BottomMenu.BottomMenu
import com.varenie.homebar.view.navigation.NavigationTree

@ExperimentalMaterial3Api
@Composable
fun MainScreen() {
    Scaffold(
        topBar = {},
        bottomBar = { BottomMenu()},
        content = { paddingValues -> 
            Box(modifier = Modifier.padding(paddingValues)) {
                NavigationTree()
            }
        }
    )
}