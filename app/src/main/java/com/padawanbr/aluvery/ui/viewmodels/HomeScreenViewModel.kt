package com.padawanbr.aluvery.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.padawanbr.aluvery.dao.ProductDao
import com.padawanbr.aluvery.model.Product
import com.padawanbr.aluvery.sampledata.sampleCandies
import com.padawanbr.aluvery.sampledata.sampleDrinks
import com.padawanbr.aluvery.sampledata.sampleProducts
import com.padawanbr.aluvery.ui.states.HomeScreenUiState

class HomeScreenViewModel : ViewModel() {

    private val dao = ProductDao()

    var uiState: HomeScreenUiState by mutableStateOf(
        HomeScreenUiState(
            sections = mapOf(
                "Todos produtos" to dao.products(),
                "Promoções" to sampleDrinks + sampleCandies,
                "Doces" to sampleCandies,
                "Bebidas" to sampleDrinks
            ),
            onSearchChange = {
                uiState = uiState.copy(
                    searchText = it,
                    searchedProducts = searchedProducts(it)
                )
            }
        ))
        private set

    private fun containsInNameOrDescription(text: String) = { product: Product ->
        product.name.contains(
            text,
            ignoreCase = true,
        ) || product.description?.contains(
            text,
            ignoreCase = true,
        ) ?: false
    }

    private fun searchedProducts(text: String): List<Product> =
        if (text.isNotBlank()) {
            sampleProducts.filter(
                containsInNameOrDescription(text)
            ) + dao.products().filter(
                containsInNameOrDescription(text)
            )
        } else emptyList()
}
