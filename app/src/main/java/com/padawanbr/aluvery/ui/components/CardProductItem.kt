package com.padawanbr.aluvery.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.padawanbr.aluvery.R
import com.padawanbr.aluvery.extensions.toBrazilianCurrency
import com.padawanbr.aluvery.model.Product
import com.padawanbr.aluvery.sampledata.sampleProducts
import com.padawanbr.aluvery.ui.theme.AluveryTheme

@Composable
fun CardProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    elevation: Dp = 4.dp,
    expanded: Boolean = false
) {

    var isExpanded by rememberSaveable { mutableStateOf(expanded) }

    Card(
        modifier
            .fillMaxWidth()
            .heightIn(150.dp)
            .clickable { isExpanded = !isExpanded },
        elevation = elevation
    ) {
        Column {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.primaryVariant)
                    .padding(16.dp)
            ) {
                Text(
                    text = product.name
                )
                Text(
                    text = product.price.toBrazilianCurrency()
                )
            }

            product.description?.let {
                Text(
                    text = it,
                    Modifier
                        .padding(16.dp),
                    overflow = if (isExpanded) TextOverflow.Visible else TextOverflow.Ellipsis,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 2
                )
            }

        }
    }
}

@Preview
@Composable
private fun CardProductItemPreview() {
    AluveryTheme {
        Surface {
            CardProductItem(
                product = sampleProducts.random(),
            )
        }
    }
}


@Preview
@Composable
private fun CardProductItemWithDescriptionPreview() {
    AluveryTheme {
        Surface {
            CardProductItem(
                product = sampleProducts[2],
            )
        }
    }
}

@Preview
@Composable
private fun CardProductItemWithDescriptionExpendedPreview() {
    AluveryTheme {
        Surface {
            CardProductItem(
                product = sampleProducts[2],
                expanded = true,
            )
        }
    }
}