package com.padawanbr.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


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
    Row (modifier = Modifier.width(300.dp)
        .height(150.dp)){

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .background(Color.Blue)
                .width(100.dp)
        )
        Column {
            Text(modifier = Modifier
                .background(Color.LightGray).padding(16.dp).fillMaxWidth(),
                text = "Test 1")
            Text(modifier = Modifier.padding(16.dp).height(80.dp).fillMaxWidth(),
                text = "Test 2")
        }
    }
}