package com.padawanbr.aluvery.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.padawanbr.aluvery.R
import com.padawanbr.aluvery.model.Product
import java.math.BigDecimal

@Composable
fun ProductSection() {
    Column {
        Text(
            text = "Promoções",
            Modifier.padding(
                start = 16.dp,
                end = 16.dp,
            ),
            fontSize = 16.sp,
            fontWeight = FontWeight(400)
        )
        Row(
            Modifier
                .padding(
                    top = 8.dp,
                )
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ProdutItem(
                Product(
                    name = "hamburguer",
                    image = R.drawable.hamburguer,
                    price = BigDecimal("12.99")
                )
            )
            ProdutItem(
                Product(
                    name = "fritas",
                    image = R.drawable.fritas,
                    price = BigDecimal("12.99")
                )
            )
            ProdutItem(
                Product(
                    name = "pizza",
                    image = R.drawable.pizza,
                    price = BigDecimal("12.99")
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductSectionPreview() {
    ProductSection()
}
