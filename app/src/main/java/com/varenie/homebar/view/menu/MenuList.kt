package com.varenie.homebar.view.menu

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varenie.homebar.R
import com.varenie.homebar.database.menu.MenuEntity
import com.varenie.homebar.model.AlcoType
import com.varenie.homebar.view.theme.Purple80

@Composable
fun MenuList(
    list: List<MenuEntity>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
    ) {
        items(list.size) {
            MenuItem(list[it])
        }
    }
}

@Composable
fun MenuItem(
    item: MenuEntity,
    modifier: Modifier = Modifier
) {
    val isExpanded = remember { mutableStateOf(false) }
    Box(
        modifier = modifier
            .padding(6.dp)
            .fillMaxWidth()
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(10.dp)
            )
            .background(Purple80)
            .clickable {
                isExpanded.value = !isExpanded.value
            }
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_beer),
                    contentDescription = "beer",
                    modifier = Modifier
                        .size(48.dp)
                )
                Text(
                    text = item.title,
                    color = Color.Black,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
//                        .fillMaxWidth()
                        .padding(top = 6.dp)
                )
                Text(
                    text = countVolume(item.ingredients),
                    color = Color.Black,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
//                        .fillMaxWidth()
                        .padding(top = 6.dp)
                )
            }

            ExpandableView(
                isExpanded.value,
                item
            )

            CartView()

        }
    }
}

@Composable
fun ExpandableView(
    isExpanded: Boolean,
    item: MenuEntity
) {
    // Opening Animation
    val expandTransition = remember {
        expandVertically(
            expandFrom = Alignment.Top,
            animationSpec = tween(300)
        ) + fadeIn(
            animationSpec = tween(300)
        )
    }

    // Closing Animation
    val collapseTransition = remember {
        shrinkVertically(
            shrinkTowards = Alignment.Top,
            animationSpec = tween(300)
        ) + fadeOut(
            animationSpec = tween(300)
        )
    }
    AnimatedVisibility(
        visible = isExpanded,
        enter = expandTransition,
        exit = collapseTransition
    ) {
        Column(
            modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
        ) {
            Text(
                text = convertIngridientsToString(item.ingredients),
                color = Color.Black,
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(top = 2.dp, bottom = 2.dp)
            )

            Text(
                text = item.recipe,
                color = Color.Black,
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(top = 2.dp, bottom = 2.dp)
            )

            Text(
                text = item.description,
                color = Color.Black,
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun CartView() {
    //TODO:  надо подумать, как сделать удобно и красиво
}

//@Preview
@Composable
fun ItemPreview() {
    MenuItem(item = MenuEntity(
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
    ))
}

@Preview
@Composable
fun ListPreview() {
    MenuList(list = listOf(
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
    ))
}

fun convertIngridientsToString(ingrids: Map<AlcoType, Int>): String {
    var result = ""

    ingrids.entries.forEach {
        result = "${result}${it.key} ${it.value}мл\n"
    }

    return result
}

fun countVolume(ingredients: Map<AlcoType, Int>): String {
    var res = 0
    ingredients.values.forEach {
        res += it
    }
    return "$res мл"
}

