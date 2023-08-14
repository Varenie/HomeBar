package com.varenie.homebar.view.bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.varenie.homebar.R
import com.varenie.homebar.model.AlcoType
import com.varenie.homebar.model.BarItemContent
import com.varenie.homebar.model.BottomNavContent
import com.varenie.homebar.view.navigation.BottomMenu
import com.varenie.homebar.view.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun BarScreen() {
     Scaffold(
         modifier = Modifier
             .background(Purple40)
             .fillMaxSize(),
         floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(Icons.Filled.Add, "")
            }
         },
         content = {
             val p = it
             BarList(listOf(
                 BarItemContent("Jim Beam", AlcoType.BOURBON, 500),
                 BarItemContent("Jemeson", AlcoType.WHISKEY, 200),
                 BarItemContent("Parka", AlcoType.VODKA, 700),
                 BarItemContent("Barister", AlcoType.GIN, 100),
             ))
         },
         bottomBar = {
             BottomMenu(
                 listOf(
                     BottomNavContent("Menu", R.drawable.ic_menu),
                     BottomNavContent("Bar", R.drawable.ic_bar_inventory),
                     BottomNavContent("Cart", R.drawable.ic_cart)
                 ),
//                 modifier = Modifier.align(Alignment.BottomCenter)
             )
         }
     )
}