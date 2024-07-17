package com.dgswalphamales.alphamap.domain.article.presentation.dto.request

data class ArticleRequest(
    val tag: String,
    val latitude: Double,
    val hardness: Double,
    val title: String,
    val content: String,
    val imgUrl: String,
    val donationDescription: String
)
