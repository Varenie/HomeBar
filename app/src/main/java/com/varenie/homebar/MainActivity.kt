package com.varenie.homebar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.varenie.homebar.view.bar.BarScreen
import com.varenie.homebar.view.theme.HomeBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeBarTheme {
                // A surface container using the 'background' color from the theme
                BarScreen()
            }
        }
    }
}