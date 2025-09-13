package pe.edu.upc.easyshop.core

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon

import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.upc.easyshop.core.ui.theme.EasyShopTheme

@Composable
fun Main() {

    val buttonNavigationItems = listOf(
        ButtonNavigationItem.Home,
        ButtonNavigationItem.Favorite,
        ButtonNavigationItem.Cart,
        ButtonNavigationItem.Profile
    )

    val selectedItem = remember {
        mutableStateOf<ButtonNavigationItem>(ButtonNavigationItem.Home)
    }

    Scaffold(
        bottomBar = {
            BottomAppBar {
                buttonNavigationItems.forEach { item ->
                    NavigationBarItem(
                    selected = item == selectedItem.value,
                    onClick = {
                        selectedItem.value = item
                    },
                    icon = {
                        Icon(item.icon, contentDescription = item.label)
                    },
                    label = {
                        Text(text = item.label)
                    }
                )
                }
            }
        }
    ) {
        Column(modifier = Modifier.padding(it)) {

        }
    }
}

sealed class ButtonNavigationItem(val icon: ImageVector,
                                  val label: String
) {
    object Home: ButtonNavigationItem(Icons.Default.Home, "Home")
    object Favorite: ButtonNavigationItem(Icons.Default.Favorite, "Favorite")
    object Cart: ButtonNavigationItem(Icons.Default.ShoppingCart, "Cart")
    object Profile: ButtonNavigationItem(Icons.Default.Person, "Profile")
}

@Preview
@Composable
fun MainPreview() {
    EasyShopTheme {
        Main()
    }
}