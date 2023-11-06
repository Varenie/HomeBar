package com.varenie.homebar.view.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.varenie.homebar.R
import com.varenie.homebar.database.menu.MenuEntity
import com.varenie.homebar.model.AlcoType
import com.varenie.homebar.view.theme.Purple40
import com.varenie.homebar.view.theme.Purple80
import com.varenie.homebar.viewmodels.menu.MenuViewModel

@Composable
fun MenuScreen() {
    val showDialog = remember { mutableStateOf(false) }
    val viewModel: MenuViewModel = hiltViewModel()
    Box {
        Column(
            modifier = Modifier
                .background(Purple40)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier
                    .padding(6.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.all_menu),
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Purple80)
                        .weight(0.5f)
                        .clickable { },
                )

                Text(
                    text = stringResource(id = R.string.available),
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Purple80)
                        .weight(0.5f)
                        .clickable { },
                )
            }
            MenuList(list = testList)

        }
        FloatingActionButton(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd),
            onClick = { viewModel.navigateToAdd() }
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