package com.padawanbr.aluvery.ui.states

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.padawanbr.aluvery.sampledata.sampleProducts

class HomeScreenUiState(searchText: String = "") {

    var text by mutableStateOf(searchText)

    val searchedProducts get() =  if (text.isNotBlank()) {
        sampleProducts.filter { product ->
            product.name.contains(text, ignoreCase = true) ||
                    product.description?.contains(text, ignoreCase = true) ?: false
        }
    } else emptyList()

    fun isShowSection(): Boolean {
        return text.isBlank()
    }

}