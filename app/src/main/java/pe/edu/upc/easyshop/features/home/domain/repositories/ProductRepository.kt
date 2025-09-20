package pe.edu.upc.easyshop.features.home.domain.repositories

import pe.edu.upc.easyshop.shared.domain.models.Product

interface ProductRepository {
    suspend fun getAllProducts(): List<Product>
}