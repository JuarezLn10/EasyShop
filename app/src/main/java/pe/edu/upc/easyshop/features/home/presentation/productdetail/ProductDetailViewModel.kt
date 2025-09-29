package pe.edu.upc.easyshop.features.home.presentation.productdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upc.easyshop.features.home.domain.repositories.ProductRepository
import pe.edu.upc.easyshop.shared.domain.models.Product

class ProductDetailViewModel(private val repository: ProductRepository) : ViewModel() {
    private val _product = MutableStateFlow<Product?>(null)
    val product: StateFlow<Product?> = _product

    fun getProductById(id: Int) {
        viewModelScope.launch {
            _product.value = repository.getProductId(id)
        }
    }

    fun toggleFavorite() {
        viewModelScope.launch {
            _product.value?.let { product ->
                if (product.isFavorite) {
                    repository.delete(product)
                } else {
                    repository.insert(product)
                }

                _product.value = product.copy(
                    isFavorite = !product.isFavorite
                )

            }
        }
    }
}