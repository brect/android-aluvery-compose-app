package com.padawanbr.aluvery.ui.states

import com.padawanbr.aluvery.model.Product

class HomeScreenUiState(
    val sections: Map<String, List<Product>> = emptyMap(),
    val searchedProducts: List<Product> = emptyList(),
    val searchText: String = "",
    val onSearchChange: (String) -> Unit = {}
) {

    fun isShowSection(): Boolean {
        return searchText.isBlank()
    }
}