package com.example.chatwise_assignment

data class Product(
    val brand: String,
    val category: String,
    val description: String,
    val discountPercentage: Double,
    val id: Int,
    val images: List<String>,
    val price: Int,
    val rating: Double,
    val stock: Int,
    val thumbnail: String,
    val title: String,

) {

    val imageUrl: String
        get() = images.firstOrNull() ?: ""
}
