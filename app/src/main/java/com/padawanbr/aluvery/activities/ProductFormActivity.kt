package com.padawanbr.aluvery.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.padawanbr.aluvery.dao.ProductDao
import com.padawanbr.aluvery.ui.screens.ProductFormScreen
import com.padawanbr.aluvery.ui.theme.AluveryTheme

class ProductFormActivity : ComponentActivity() {

    private val dao = ProductDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    ProductFormScreen(
                        onSaveClick = { product ->
                            dao.save(product)
                            finish()
                        })
                }
            }
        }
    }
}