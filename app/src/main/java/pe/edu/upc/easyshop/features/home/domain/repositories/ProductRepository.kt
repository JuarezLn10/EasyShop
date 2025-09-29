package pe.edu.upc.easyshop.features.home.domain.repositories

import pe.edu.upc.easyshop.shared.domain.models.Product

interface ProductRepository {
    suspend fun getAllProducts(): List<Product>

    suspend fun getProductId(id: Int): Product?

    suspend fun insert(product: Product)

    suspend fun delete(product: Product)
}