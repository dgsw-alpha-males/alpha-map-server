package com.dgswalphamales.alphamap.domain.article.domain.model

import java.time.LocalDateTime

data class Article(
    val id: Long? = null,
    val tag: String = "",
    val latitude: Double = 0.0,
    val hardness: Double = 0.0,
    val title: String = "",
    val content: String = "",
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val imgUrl: String = ""
)
