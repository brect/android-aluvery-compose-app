package com.padawanbr.aluvery.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.padawanbr.aluvery.dao.ProductDao
import com.padawanbr.aluvery.model.Product
import com.padawanbr.aluvery.ui.states.ProductFormUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.math.BigDecimal
import java.text.DecimalFormat

class ProductFormScreenViewModel : ViewModel() {

  private val dao = ProductDao()

  private val _uiState: MutableStateFlow<ProductFormUiState> = MutableStateFlow(
    ProductFormUiState()
  )

  val uiState get() = _uiState.asStateFlow()

  private val formatter = DecimalFormat("#.##")

  init {
    _uiState.update { currentState ->
      currentState.copy(
        onUrlChange = {
          _uiState.value = _uiState.value.copy(
            url = it,
          )
        },
        onNameChange = {
          _uiState.value = _uiState.value.copy(
            name = it,
          )
        },
        onPriceChange = {
          val price = try {
            formatter.format(BigDecimal(it))
          } catch (ex: IllegalArgumentException) {
            if (it.isBlank()) {
              it
            } else {
              null
            }
          }

          price?.let {
            _uiState.value = _uiState.value.copy(
              price = price,
            )
          }

        },
        onDescriptionChange = {
          _uiState.value = _uiState.value.copy(
            description = it,
          )
        },
      )
    }
  }

  fun save() {
    _uiState.value.run {
      val convertedPrice = try {
        BigDecimal(price)
      } catch (e: NumberFormatException) {
        BigDecimal.ZERO
      }

      val product = Product(
        name = name,
        image = url,
        price = convertedPrice,
        description = description
      )

      dao.save(product)
    }
  }
}