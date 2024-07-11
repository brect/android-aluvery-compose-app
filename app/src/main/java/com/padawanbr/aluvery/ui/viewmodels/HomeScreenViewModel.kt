package com.padawanbr.aluvery.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.padawanbr.aluvery.dao.ProductDao
import com.padawanbr.aluvery.model.Product
import com.padawanbr.aluvery.sampledata.sampleCandies
import com.padawanbr.aluvery.sampledata.sampleDrinks
import com.padawanbr.aluvery.sampledata.sampleProducts
import com.padawanbr.aluvery.ui.states.HomeScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {

    private val dao = ProductDao()

    private var _uiState: MutableStateFlow<HomeScreenUiState> = MutableStateFlow(
        HomeScreenUiState()
    )

    val uiState get() = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy(
                onSearchChange =
                {
                    _uiState.value = _uiState.value.copy(
                        searchText = it,
                        searchedProducts = searchedProducts(it)
                    )
                }
            )
        }

        viewModelScope.launch {
            dao.products().collect { produts ->
                _uiState.value = _uiState.value.copy(
                    sections = mapOf(
                        "Todos produtos" to produts,
                        "Promoções" to sampleDrinks + sampleCandies,
                        "Doces" to sampleCandies,
                        "Bebidas" to sampleDrinks
                    ),
                    searchedProducts = searchedProducts(_uiState.value.searchText)
                )
            }
        }
    }

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
            ) + dao.products().value.filter(
                containsInNameOrDescription(text)
            )
        } else emptyList()

}
