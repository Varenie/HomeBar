package com.varenie.homebar.view.bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varenie.homebar.database.bar.BarEntity
import com.varenie.homebar.view.theme.Purple80

@Composable
fun BarList(
    list: List<BarEntity>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.
                fillMaxWidth()
    ) {
        items(list.size) {
            BarItem(item = list[it])
        }
    }
}

@Composable
fun BarItem(
    item: BarEntity,
    modifier: Modifier = Modifier,
) {
    BoxWithConstraints(
        modifier = modifier
            .padding(6.dp)
            .aspectRatio(6f)
            .clip(RoundedCornerShape(10.dp))
            .background(Purple80)
    ) {
        Column {
            Text(
                text = item.title,
                color = Color.Black,
                fontSize = 24.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                RoundedCornerChip(content = item.alcoType.toString())

                Text(
                    text = "${item.volume}ml",
                    color = Color.Black
                )
            }
        }
    }
}

@Composable
private fun RoundedCornerChip(
    content: String,
    contentColor: Color = Color.Black
) {
    val shape = RoundedCornerShape(60)
    Card(
        modifier = Modifier
            .wrapContentSize(),
//            .border(shape = shape, width = 2.dp, color = borderColor),
        shape = shape,

//        elevation = CardElevation(10.dp),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .wrapContentSize()
                .background(Color.LightGray),
        ) {
            Text(
                text = content,
                color = contentColor,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp),
            )
        }
    }
}