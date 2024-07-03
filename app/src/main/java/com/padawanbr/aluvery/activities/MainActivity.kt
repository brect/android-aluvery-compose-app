package com.padawanbr.aluvery.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.padawanbr.aluvery.sampledata.sampleSections
import com.padawanbr.aluvery.ui.screens.HomeScreen
import com.padawanbr.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(onFabClick = {
                startActivity(
                    Intent(
                        this,
                        ProductFormActivity::class.java
                    )
                )
            })
        }
    }
}


@Composable
fun App(onFabClick: () -> Unit = {}) {
    AluveryTheme {
        Surface {
            Scaffold(floatingActionButton = {
                FloatingActionButton(onClick = onFabClick) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Botão adicionar produto"
                    )
                }
            }) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    HomeScreen(
                        sampleSections
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun AppPreview() {
    App()
}