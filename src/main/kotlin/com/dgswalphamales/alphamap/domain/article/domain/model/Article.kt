package com.dgswalphamales.alphamap.domain.article.domain.model

import java.time.LocalDateTime

data class Article(
    val id: Long? = null,
    val tag: String = "",
    val title: String = "",
    val content: String = "",
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val imgUrl: String = "",
    val donationDescription: String = ""
)
