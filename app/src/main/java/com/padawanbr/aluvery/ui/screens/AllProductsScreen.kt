package com.padawanbr.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.padawanbr.aluvery.model.Product
import com.padawanbr.aluvery.sampledata.sampleProducts
import com.padawanbr.aluvery.ui.components.ProductItem
import com.padawanbr.aluvery.ui.theme.AluveryTheme


@Composable
fun AllProductsScreen(products: List<Product>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp)
    ) {

        item(span = {
            GridItemSpan(maxLineSpan)
        }) {
            Text(text = "Todos produtos", fontSize = 32.sp)
        }

        items(products) { p ->
            ProductItem(product = p)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    AluveryTheme {
        Surface {
            AllProductsScreen(sampleProducts)
        }
    }
}