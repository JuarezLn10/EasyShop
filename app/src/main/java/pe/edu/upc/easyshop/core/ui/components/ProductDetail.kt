package pe.edu.upc.easyshop.core.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.upc.easyshop.R
import pe.edu.upc.easyshop.core.ui.theme.EasyShopTheme

@Composable
fun ProductDetail() {

    val selectedColorSwatch = remember {
        mutableStateOf<ColorSwatch>(ColorSwatch.Red)
    }

    val colorSwatches = listOf(
        ColorSwatch.Black,
        ColorSwatch.Blue,
        ColorSwatch.Green,
        ColorSwatch.Red
    )

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier.fillMaxWidth(0.9f),
            verticalAlignment = Alignment.CenterVertically) {

            Box(
                modifier = Modifier
                    .height(36.dp)
                    .width(40.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.inversePrimary),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Default.ArrowBackIosNew,
                    contentDescription = null
                )
            }

            Column(
                modifier = Modifier.weight(0.1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Details",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineMedium
                )
            }

            Box(
                modifier = Modifier
                    .height(36.dp)
                    .width(40.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.inversePrimary)
                , contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Default.Share,
                    contentDescription = null
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(368.dp)
                .padding(12.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.inversePrimary)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
                    .padding(6.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

            Icon(
                Icons.Default.Favorite,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(16.dp)
                    .size(36.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.inverseOnSurface)
            )

            LazyRow(modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                items(colorSwatches) { colorSwatch ->
                    FilterChip(
                        selected = colorSwatch == selectedColorSwatch.value,
                        onClick = {
                            selectedColorSwatch.value = colorSwatch
                        },
                        label = {
                            Text("")
                        }
                    )
                }
            }
        }
    }
}

sealed class ColorSwatch(@DrawableRes val image: Int) {
    object Black : ColorSwatch(R.drawable.ic_launcher_foreground)
    object Blue : ColorSwatch(R.drawable.ic_launcher_foreground)
    object Green : ColorSwatch(R.drawable.ic_launcher_foreground)
    object Red : ColorSwatch(R.drawable.ic_launcher_foreground)
}

@Preview
@Composable
fun ProductComposablePreview() {
    EasyShopTheme {
        ProductDetail()
    }
}