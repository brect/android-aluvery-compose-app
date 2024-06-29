package com.padawanbr.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.padawanbr.aluvery.model.Product
import com.padawanbr.aluvery.sampledata.sampleProducts
import com.padawanbr.aluvery.sampledata.sampleSections
import com.padawanbr.aluvery.ui.components.CardProductItem
import com.padawanbr.aluvery.ui.components.ProductsSection
import com.padawanbr.aluvery.ui.components.SearchTextField
import com.padawanbr.aluvery.ui.theme.AluveryTheme

@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>,
    searchText: String = ""
) {
    Column {
        var text by remember {
            mutableStateOf(searchText)
        }

        SearchTextField(searchText = text, onSearchTextChange = {
            text = it
        })

        val searchedProducts = filterProductList(text)

        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            if (text.isBlank()) {
                for (section in sections) {
                    val title = section.key
                    val products = section.value
                    item {
                        ProductsSection(
                            title = title,
                            products = products
                        )
                    }
                }
            } else {
                items(searchedProducts) { p ->
                    CardProductItem(
                        product = p, Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
        }
    }

}

@Composable
private fun filterProductList(text: String) = remember(text) {
    if (text.isNotBlank()) {
        sampleProducts.filter { product ->
            product.name.contains(text, ignoreCase = true) ||
                    product.description?.contains(text, ignoreCase = true) ?: false
        }
    } else emptyList()
}


@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(sampleSections)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenWithSearchTextPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(
                sampleSections,
                "Hamburguer"
            )
        }
    }
}