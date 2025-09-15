package pe.edu.upc.easyshop.features.home.data.remote

data class ProductDto(
    val availabilityStatus: String?,
    val brand: String?,
    val category: String?,
    val description: String?,
    val dimensions: DimensionsDto?,
    val discountPercentage: Double?,
    val id: Int?,
    val images: List<String?>?,
    val metaDto: MetaDto?,
    val minimumOrderQuantity: Int?,
    val price: Double?,
    val rating: Double?,
    val returnPolicy: String?,
    val reviewDto: List<ReviewDto?>?,
    val shippingInformation: String?,
    val sku: String?,
    val stock: Int?,
    val tags: List<String?>?,
    val thumbnail: String?,
    val title: String?,
    val warrantyInformation: String?,
    val weight: Int?
)