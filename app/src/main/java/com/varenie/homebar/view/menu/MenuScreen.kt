package com.varenie.homebar.view.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.varenie.homebar.database.menu.MenuEntity
import com.varenie.homebar.model.AlcoType
import com.varenie.homebar.view.theme.Purple40

@Composable
fun MenuScreen() {
    val showDialog = remember { mutableStateOf(false) }

    Box(modifier = Modifier
        .background(Purple40)
        .fillMaxSize()
    ) {
        MenuList(list = testList)
        FloatingActionButton(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd),
            onClick = { showDialog.value = true }
        ) {
            Icon(Icons.Filled.Add, "")
        }
    }
}

val testList = listOf(
    MenuEntity(
        0,
        "Негрони",
        mapOf(
            AlcoType.VERMOUTH to 30,
            AlcoType.GIN to 30,
            AlcoType.BITTER to 30
        ),
        "Наполни бокал льдом\nналить ингридиенты\nразмешать\nукрасить апельсиновой цедрой",
        "потребуется бокал рокс, джиггер, ложка",
        "рокс"
    ),
    MenuEntity(
        0,
        "Негрони",
        mapOf(
            AlcoType.VERMOUTH to 30,
            AlcoType.GIN to 30,
            AlcoType.BITTER to 30
        ),
        "Наполни бокал льдом\nналить ингридиенты\nразмешать\nукрасить апельсиновой цедрой",
        "потребуется бокал рокс, джиггер, ложка",
        "рокс"
    ),
    MenuEntity(
        0,
        "Негрони",
        mapOf(
            AlcoType.VERMOUTH to 30,
            AlcoType.GIN to 30,
            AlcoType.BITTER to 30
        ),
        "Наполни бокал льдом\nналить ингридиенты\nразмешать\nукрасить апельсиновой цедрой",
        "потребуется бокал рокс, джиггер, ложка",
        "рокс"
    )
)