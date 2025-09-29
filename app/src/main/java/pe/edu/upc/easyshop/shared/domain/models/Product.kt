package pe.edu.upc.easyshop.shared.domain.models

data class Product(
    val id: Int,
    val name: String,
    val image: String,
    val price: Double,
    var isFavorite: Boolean = false
)