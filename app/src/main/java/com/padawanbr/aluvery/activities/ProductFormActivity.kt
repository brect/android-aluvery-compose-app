package com.padawanbr.aluvery.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.padawanbr.aluvery.sampledata.sampleSections
import com.padawanbr.aluvery.ui.screens.HomeScreen
import com.padawanbr.aluvery.ui.theme.AluveryTheme

class ProductFormActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductFormApp()
        }
    }

}


@Composable
fun ProductFormApp() {
    AluveryTheme {
        Surface {
            HomeScreen(
                sampleSections
            )
        }
    }
}