package pe.edu.upc.easyshop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.upc.easyshop.ui.theme.EasyShopTheme

@Composable
fun Home() {

    val search = remember {
        mutableStateOf("")
    }

    val selectedCategory = remember {
        mutableStateOf<Category>(Category.All)
    }

    val categories = listOf(
        Category.All,
        Category.Men,
        Category.Women,
        Category.Boys,
        Category.Girls
    )

    val products = listOf(
        Product(name = "Cotton T-Shirt", image = "", price = 69.00),
        Product(name = "Cotton T-Shirt", image = "", price = 69.00),
        Product(name = "Cotton T-Shirt", image = "", price = 69.00)
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.height(64.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.inversePrimary),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text("Hello Farid",
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.Gray
                )
                Text("Good morning!",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Row {
                RoundedICon(icon = Icons.Outlined.Notifications)
                RoundedICon(icon = Icons.Outlined.ShoppingCart)
            }
        }

        Row(modifier = Modifier
            .height(64.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = search.value,
                onValueChange = { search.value = it },
                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null
                    )
                },
                placeholder = {
                    Text("Search")
                },
                modifier = Modifier.weight(1f)
            )

            RoundedICon(Icons.Outlined.FilterList)
        }

        Row(modifier = Modifier.height(64.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Categories",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            TextButton(onClick = {}) {
                Text("See all")
            }
        }

        LazyRow {
            items(categories) { category ->
                FilterChip(
                    selected = category == selectedCategory.value,
                    onClick = {
                        selectedCategory.value= category
                    },
                    label = {
                        Text(category.label)
                    },
                    modifier = Modifier.padding(8.dp)
                )
            }
        }

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(128.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.inverseOnSurface)) {
        }

        Row(modifier = Modifier.height(64.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Popular",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            TextButton(onClick = {}) {
                Text("See all")
            }
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(products) {
                products -> ProductItem(products)
            }
        }
    }
}

sealed class Category(val label: String) {
    object All: Category("All")
    object Men: Category("Men")
    object Women: Category("Women")
    object Boys: Category("Boys")
    object Girls: Category("Girls")
}

@Composable
fun ProductItem(product: Product) {
    Card (modifier = Modifier.padding(8.dp)){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(256.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .padding(8.dp)
        ) {
            Column {
                Text(
                    product.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    "$ ${product.price}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
fun RoundedICon(icon: ImageVector) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.inverseOnSurface),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview
@Composable
fun HomePreview() {
    EasyShopTheme(dynamicColor = false) {
        Home()
    }
}