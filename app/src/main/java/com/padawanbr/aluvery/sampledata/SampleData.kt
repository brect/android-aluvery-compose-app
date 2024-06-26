package com.padawanbr.aluvery.sampledata

import com.padawanbr.aluvery.R
import com.padawanbr.aluvery.model.Product
import java.math.BigDecimal


val sampleProducts = arrayListOf(
    Product(
        name = "hamburguer",
        image = R.drawable.hamburguer,
        price = BigDecimal("12.99")
    ),
    Product(
        name = "fritas",
        image = R.drawable.fritas,
        price = BigDecimal("12.99")
    ),
    Product(
        name = "pizza",
        image = R.drawable.pizza,
        price = BigDecimal("12.99")
    )
)