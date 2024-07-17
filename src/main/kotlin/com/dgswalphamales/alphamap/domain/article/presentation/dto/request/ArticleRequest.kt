package com.dgswalphamales.alphamap.domain.article.presentation.dto.request

data class ArticleRequest(
    val tag: String,
    val title: String,
    val content: String,
    val imgUrl: String,
    val donationDescription: String
)
