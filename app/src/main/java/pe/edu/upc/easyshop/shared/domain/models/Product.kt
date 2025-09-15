package pe.edu.upc.easyshop.shared.domain.models

data class Product(
    val name: String,
    val image: String,
    val price: Double
)

val products = listOf(
    Product(
        name = "Essence Mascara Lash Princess",
        image = "https://cdn.dummyjson.com/product-images/beauty/essence-mascara-lash-princess/1.webp",
        price = 9.99
    ),
    Product(
        name = "Eyeshadow Palette with Mirror",
        image = "https://cdn.dummyjson.com/product-images/beauty/eyeshadow-palette-with-mirror/1.webp",
        price = 19.99
    ),
    Product(
        name = "Powder Canister",
        image = "https://cdn.dummyjson.com/product-images/beauty/powder-canister/1.webp",
        price = 14.99
    )
)