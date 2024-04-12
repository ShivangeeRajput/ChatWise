package com.example.chatwise_assignment

data class responseDataClass(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)