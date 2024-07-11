package com.padawanbr.aluvery.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import com.padawanbr.aluvery.ui.screens.ProductFormScreen
import com.padawanbr.aluvery.ui.theme.AluveryTheme
import com.padawanbr.aluvery.ui.viewmodels.ProductFormScreenViewModel

class ProductFormActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      AluveryTheme {
        Surface {

          val viewModel by viewModels<ProductFormScreenViewModel>()

          ProductFormScreen(
            viewModel = viewModel,
            onSaveClick = {
              finish()
            }
          )
        }
      }
    }
  }
}