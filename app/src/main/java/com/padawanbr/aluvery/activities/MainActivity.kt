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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.padawanbr.aluvery.dao.ProductDao
import com.padawanbr.aluvery.model.Product
import com.padawanbr.aluvery.sampledata.sampleCandies
import com.padawanbr.aluvery.sampledata.sampleDrinks
import com.padawanbr.aluvery.sampledata.sampleProducts
import com.padawanbr.aluvery.sampledata.sampleSections
import com.padawanbr.aluvery.ui.screens.HomeScreen
import com.padawanbr.aluvery.ui.states.HomeScreenUiState
import com.padawanbr.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {

    private val dao = ProductDao()

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
            }) {
                val products = dao.products()

                val sections = mapOf(
                    "Todos produtos" to products,
                    "Promoções" to sampleDrinks + sampleCandies,
                    "Doces" to sampleCandies,
                    "Bebidas" to sampleDrinks
                )

                var text by remember {
                    mutableStateOf("")
                }

                fun containsInNameOrDescription() = { product: Product ->
                    product.name.contains(
                        text,
                        ignoreCase = true,
                    ) ||
                            product.description?.contains(
                                text,
                                ignoreCase = true,
                            ) ?: false
                }

                val searchedProducts = remember(text, products) {
                    if (text.isNotBlank()) {
                        sampleProducts.filter(containsInNameOrDescription()) + products.filter(
                            containsInNameOrDescription()
                        )
                    } else emptyList()
                }


                val state = remember(products, text) {
                    HomeScreenUiState(
                        sections = sections,
                        searchedProducts = searchedProducts,
                        searchText = text,
                        onSearchChange = {
                            text = it
                        }
                    )
                }

                HomeScreen(
                    state = state
                )
            }
        }
    }
}

@Composable
fun App(
    onFabClick: () -> Unit = {},
    content: @Composable () -> Unit = {}
) {
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
                    content()
                }
            }
        }
    }
}

@Preview
@Composable
fun AppPreview() {
    App {
        HomeScreen(
            HomeScreenUiState(sections = sampleSections)
        )
    }
}