@file:OptIn(ExperimentalMaterial3Api::class)

package com.varenie.homebar.view.bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.varenie.homebar.R
import com.varenie.homebar.model.AlcoType
import com.varenie.homebar.view.theme.Purple40
import com.varenie.homebar.viewmodels.bar.BarEvent
import com.varenie.homebar.viewmodels.bar.BarViewModel

@Composable
fun BarScreen() {
    val showDialog = remember { mutableStateOf(false) }
    val viewModel: BarViewModel = hiltViewModel()
    viewModel.onEvent(BarEvent.InitViewModel)

    val barList = viewModel.barItems.collectAsState()
    Box(
        modifier = Modifier
            .background(Purple40)
            .fillMaxSize()
    ) {
        BarList(
            barList.value
        )
        if (showDialog.value) {
            OpenDialog(
                onConfirm = { name: String, type: AlcoType, volume: Int ->
                    viewModel.onEvent(BarEvent.SaveBarItem(name, type, volume))
                    if (viewModel.confirmVisible.value) {
                        showDialog.value = false
                    }
                },
                onDismiss = {
                    showDialog.value = false
                }
            )
        }

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

@Composable
private fun OpenDialog(
    onConfirm: (String, AlcoType, Int) -> Unit,
    onDismiss: () -> Unit
) {
    val alcName = remember { mutableStateOf("") }
    val alcType = remember { mutableStateOf(AlcoType.NO_SELECTION) }
    val volume = remember { mutableStateOf(0) }

    AlertDialog(
        title = { Text(text = stringResource(id = R.string.bar_dialog_title)) },
        text = {
            AddDialogContent(alcName, alcType, volume)
        },
        onDismissRequest = { onDismiss() },
        confirmButton = {
            Button(
                onClick = {
                    onConfirm(
                        alcName.value,
                        alcType.value,
                        volume.value
                    )
                }
            ) {
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

