package com.padawanbr.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.padawanbr.aluvery.model.Product
import com.padawanbr.aluvery.sampledata.sampleSections
import com.padawanbr.aluvery.ui.components.ProductsSection
import com.padawanbr.aluvery.ui.theme.AluveryTheme

@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>
) {
    LazyColumn(
        Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        item { Spacer(modifier = Modifier) }

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

        item { Spacer(modifier = Modifier) }
    }
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