package com.varenie.homebar.view.BottomMenu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.varenie.homebar.model.BottomNavContent
import com.varenie.homebar.view.theme.PurpleGrey40
import com.varenie.homebar.viewmodels.BottomMenuViewModel

@Composable
fun BottomMenu(
    items: List<BottomNavContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = Color.White,
    activeTextColor: Color = Color.Black,
    inactiveTextColor: Color = Color.White,
    initialSelectedItemIndex: Int = 1
) {
    var selectedItemIndex by remember { mutableStateOf(initialSelectedItemIndex) }
    val viewModel: BottomMenuViewModel = hiltViewModel()
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(PurpleGrey40)
            .padding(15.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor
            ) {
                selectedItemIndex = index
                when(it) {
                    "Menu" -> viewModel.onNavigateToMenu()
                    "Bar" -> viewModel.onNavigateToBar()
                    "Cart" -> viewModel.onNavigateToCart()
                }
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item: BottomNavContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = Color.White,
    activeTextColor: Color = Color.Black,
    inactiveTextColor: Color = Color.White,
    onItemClick: (String) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick(item.title)
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Black)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            color = if (isSelected) activeTextColor else inactiveTextColor
        )
    }
}