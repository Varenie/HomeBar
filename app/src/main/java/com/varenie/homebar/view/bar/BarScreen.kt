@file:OptIn(ExperimentalMaterial3Api::class)

package com.varenie.homebar.view.bar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.toSize
import com.varenie.homebar.R
import com.varenie.homebar.model.AlcoType
import com.varenie.homebar.model.BarItemContent
import com.varenie.homebar.model.BottomNavContent
import com.varenie.homebar.view.BottomMenu.BottomMenu
import com.varenie.homebar.view.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun BarScreen() {
    val showDialog = remember { mutableStateOf(false) }
    Scaffold(
        modifier = Modifier
            .background(Purple40)
            .fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog.value = true }
            ) {
                Icon(Icons.Filled.Add, "")
            }
        },
        content = {
            val p = it
            BarList(
                listOf(
                    BarItemContent("Jim Beam", AlcoType.BOURBON, 500),
                    BarItemContent("Jemeson", AlcoType.WHISKEY, 200),
                    BarItemContent("Parka", AlcoType.VODKA, 700),
                    BarItemContent("Barister", AlcoType.GIN, 100),
                )
            )
            if (showDialog.value) {
                OpenDialog() {
                    showDialog.value = false
                }
            }
        },
        bottomBar = {
            BottomMenu(
                listOf(
                    BottomNavContent("Menu", R.drawable.ic_menu),
                    BottomNavContent("Bar", R.drawable.ic_bar_inventory),
                    BottomNavContent("Cart", R.drawable.ic_cart)
                )
            )
        }
    )
}

@Composable
private fun OpenDialog(
//    onConfirm: () -> Unit
    onDismiss: () -> Unit
) {
    val alcName = remember { mutableStateOf("") }
    val alcType = remember { mutableStateOf(AlcoType.NO_SELECTION) }
    val volume = remember { mutableStateOf(0) }

    AlertDialog(
        title = { Text(text = "abra") },
        text = {
            AddDialogContent(alcName, alcType, volume)
        },
        onDismissRequest = { onDismiss() },
        confirmButton = {
            Button(onClick = { onDismiss() }) {
                Text(text = "Confirm")
            }
        },
        dismissButton = {
            Button(onClick = { onDismiss() }) {
                Text(text = "Dismiss")
            }
        }
    )
}

@Composable
fun AddDialogContent(
    alcName: MutableState<String>,
    alcType: MutableState<AlcoType>,
    volume: MutableState<Int>
) {
    val alcTypeArray = AlcoType.values().joinToString { it.name }.split(",")
    Column {
        TextField(
            value = alcName.value,
            onValueChange = {
                alcName.value = it
            }
        )
        DropDownMenuParameter(
            optionList = alcTypeArray,
            label = stringResource(id = R.string.typeField)
        ) {
            alcType.value = AlcoType.valueOf(it)
        }
        TextField(
            value = volume.value.toString(),
            onValueChange = {
                volume.value = it.toInt()
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenuParameter(optionList: List<String>, label:String, onParamValueChange: (String) -> Unit) {
    val expanded = remember { mutableStateOf(false) }

    val selectedText = remember { mutableStateOf("") }

    val textFieldSize = remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded.value)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown


    Column() {
        OutlinedTextField(
            value = selectedText.value,
            onValueChange = { selectedText.value = it },
            enabled = false,
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFieldSize.value = coordinates.size.toSize()
                }
                .clickable { expanded.value = !expanded.value },
            label = { Text(label) },
            trailingIcon = {
                Icon(icon, "Drop Down Icon",
                    Modifier.clickable { expanded.value = !expanded.value })
            }
        )
        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textFieldSize.value.width.toDp() })
        ) {
            optionList.forEach { label ->
                DropdownMenuItem(
                    text = { Text(text = label.trim()) },
                    onClick = {
                        selectedText.value = label.trim()
                        onParamValueChange(label.trim())
                        expanded.value = !expanded.value
                    })
            }
        }
    }
}
