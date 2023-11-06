package com.varenie.homebar.view.addcocktail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.varenie.homebar.R

@Composable
fun AddCocktailScreen() {
    val name = remember { mutableStateOf("") }
    val ingridients = remember { mutableStateOf(arrayListOf("GIN" to 30)) }
    val recipe = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TextParameter(text = name, label = stringResource(id = R.string.item_name))
        IngridientsField(ingridients = ingridients)
        TextParameter(text = recipe, label = stringResource(id = R.string.recipe))
        TextParameter(text = description, label = stringResource(id = R.string.description))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TextParameter(
    text: MutableState<String>,
    label: String
) {
    TextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        label = { Text(text = label) }
    )
}

@Composable
private fun IngridientsField(
    ingridients: MutableState<ArrayList<Pair<String, Int>>>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        IngridientsHeader()
        LazyColumn {
            items(ingridients.value.size) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = ingridients.value[it].first)
                    Text(text = ingridients.value[it].second.toString())
                    Text(text = "")
                }
            }
        }
    }
}

@Composable
private fun IngridientsHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = stringResource(id = R.string.item_name))
        Text(text = stringResource(id = R.string.volume))
        Icon(
            Icons.Filled.Add,
            "",
            modifier = Modifier
                .clickable {

                })

    }
}

@Preview
@Composable
private fun DialogPreview() {
    AddCocktailScreen()
}