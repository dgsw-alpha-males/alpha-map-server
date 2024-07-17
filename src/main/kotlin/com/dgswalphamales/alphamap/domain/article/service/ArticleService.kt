package com.dgswalphamales.alphamap.domain.article.service

import com.dgswalphamales.alphamap.domain.article.domain.ArticleEntity
import com.dgswalphamales.alphamap.domain.article.domain.ArticleRepository
import com.dgswalphamales.alphamap.domain.article.domain.model.Article
import com.dgswalphamales.alphamap.domain.article.exception.ArticleErrorCode
import com.dgswalphamales.alphamap.domain.article.presentation.dto.request.ArticleRequest
import com.dgswalphamales.alphamap.global.exception.CustomException
import com.dgswalphamales.alphamap.global.response.BaseResponse
import org.springframework.stereotype.Service

@Service
class ArticleService(
    private val articleRepository: ArticleRepository,
) {
    private fun toDomain(articleRequest: ArticleRequest): Article {
        return Article(
            title = articleRequest.title,
            content = articleRequest.content,
            imgUrl = articleRequest.imgUrl,
            donationDescription = articleRequest.donationDescription
        )
    }

    private fun toDomain(articleEntity: ArticleEntity): Article {
        return Article(
            id = articleEntity.id,
            title = articleEntity.title,
            tag = articleEntity.tag,
            content = articleEntity.content,
            createdAt = articleEntity.createdAt,
            imgUrl = articleEntity.imgUrl,
            donationDescription = articleEntity.donationDescription
        )
    }

    private fun toEntity(article: Article): ArticleEntity {
        return ArticleEntity(
            title = article.title,
            tag = article.tag,
            content = article.content,
            createdAt = article.createdAt,
            imgUrl = article.imgUrl,
            donationDescription = article.donationDescription
        )
    }

    fun creat(articleRequest: ArticleRequest) {
        articleRepository.save(
            toEntity(
                toDomain(articleRequest)
            )
        )
    }

    fun get(tag: String): BaseResponse<Article> {
        return BaseResponse(
            message = "아티클 불러오기 성공",
            data = toDomain(
                articleRepository.findByTagContains(tag) ?: throw CustomException(ArticleErrorCode.NOT_FOUND)
            )
        )
    }



}