package com.padawanbr.aluvery.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.padawanbr.aluvery.R
import com.padawanbr.aluvery.ui.theme.Purple40


@Composable
fun MyFirstComposable() {
    Text(text = "My first Composable")
    Text(text = "My first content Composable")
}

@Preview(showBackground = true)
@Composable
fun CustomLayoutPreview() {
    Column(
        modifier = Modifier
            .padding(all = 8.dp)
            .background(color = Color.Blue)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text(text = "Texto 1")
        Text(text = "Texto 2")
        Row(
            modifier = Modifier
                .padding(
                    horizontal = 8.dp, vertical = 16.dp
                )
                .background(color = Color.Yellow)
        ) {
            Text(text = "Texto 3")
            Text(text = "Texto 4")
        }
        Box(
            modifier = Modifier
                .padding(all = 8.dp)
                .background(color = Color.Red)
                .padding(all = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(all = 8.dp)
                    .background(color = Color.Cyan)
                    .padding(all = 8.dp)
            ) {
                Text(text = "Texto 5")
                Text(text = "Texto 6")
            }
            Column(
                modifier = Modifier
                    .padding(all = 8.dp)
                    .background(color = Color.White)
                    .padding(all = 8.dp)
            ) {
                Text(text = "Texto 7")
                Text(text = "Texto 8")
            }
        }
    }
}

@Preview
@Composable
fun ColumnPreview() {
    Column {
        Text(text = "Texto 1")
        Text(text = "Texto 1")
    }
}

@Preview
@Composable
fun RowPreview() {
    Row {
        Text(text = "Texto 1")
        Text(text = "Texto 1")
    }
}

@Preview
@Composable
fun BoxPreview() {
    Box {
        Text(text = "Texto 1")
        Text(text = "Texto 1")
    }
}


@Preview(showBackground = true)
@Composable
fun ChallengeComposable() {
    Row(
        modifier = Modifier
            .width(300.dp)
            .height(150.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .background(Color.Blue)
                .width(100.dp)
        )
        Column {
            Text(
                modifier = Modifier
                    .background(Color.LightGray)
                    .padding(16.dp)
                    .fillMaxWidth(),
                text = "Test 1"
            )
            Text(
                modifier = Modifier
                    .padding(16.dp)
                    .height(80.dp)
                    .fillMaxWidth(),
                text = "Test 2"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChallengeComposableCardItem() {
    Surface(
        Modifier
            .padding(8.dp),
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp
    ) {
        Row(
            Modifier
                .heightIn(200.dp)
                .width(500.dp)

        ) {

            val imageSize = 100.dp
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .width(100.dp)
                    .background(
                        brush = Brush.verticalGradient(colors = listOf(Color.Blue, Purple40))
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Imagem do produto",
                    Modifier
                        .size(imageSize)
                        .offset(imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(Alignment.Center)
                        .border(
                            brush = Brush.horizontalGradient(listOf(Purple40, Color.Blue)),
                            width = 2.dp,
                            shape = CircleShape
                        )
                )
            }
            Spacer(modifier = Modifier.width(imageSize / 2))
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = LoremIpsum(20).values.first(),
                    fontSize = 16.sp,
                    maxLines = 6,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}