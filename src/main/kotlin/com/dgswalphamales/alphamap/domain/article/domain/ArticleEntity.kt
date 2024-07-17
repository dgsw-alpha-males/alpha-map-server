package com.dgswalphamales.alphamap.domain.article.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class ArticleEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val tag: String,

    @Column(nullable = false)
    val latitude: Double,

    @Column(nullable = false)
    val hardness: Double,

    @Column(nullable = false)
    val title: String,

    @Column(length = 50000)
    val content: String,

    @Column(nullable = false)
    val createdAt: LocalDateTime,

    @Column(nullable = false)
    val imgUrl: String

)