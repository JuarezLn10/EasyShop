package pe.edu.upc.easyshop.core.root

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
import pe.edu.upc.easyshop.features.home.presentation.home.Home

@Composable
fun Main(onClick: (Int) -> Unit) {

    val bottomNavigationItems = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Favorite,
        BottomNavigationItem.Cart,
        BottomNavigationItem.Profile
    )

    val selectedItem = remember {
        mutableStateOf<BottomNavigationItem>(BottomNavigationItem.Home)
    }
    Scaffold(
        bottomBar = {
            BottomAppBar {

                bottomNavigationItems.forEach { item ->
                    NavigationBarItem(
                        selected = item == selectedItem.value,
                        onClick = {
                            selectedItem.value = item
                        },
                        icon = {
                            Icon(
                                item.icon,
                                contentDescription = item.label
                            )
                        },
                        label = {
                            Text(item.label)
                        }
                    )
                }
            }
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            Home(onClick = onClick)
        }
    }
}

sealed class BottomNavigationItem(
    val icon: ImageVector,
    val label: String
) {
    object Home : BottomNavigationItem(Icons.Default.Home, "Home")
    object Favorite : BottomNavigationItem(Icons.Default.Favorite, "Favorite")
    object Cart : BottomNavigationItem(Icons.Default.ShoppingCart, "Cart")
    object Profile : BottomNavigationItem(Icons.Default.Person, "Profile")
}

@Preview
@Composable
fun MainPreview() {
    EasyShopTheme {
        Main {}
    }
}