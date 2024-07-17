package com.dgswalphamales.alphamap.domain.article.domain

import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository : JpaRepository<ArticleEntity, Long> {

    fun findByTagContains(tag: String): ArticleEntity?

}