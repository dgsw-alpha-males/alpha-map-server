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
            tag = articleRequest.tag,
            hardness = articleRequest.hardness,
            latitude = articleRequest.latitude,
            content = articleRequest.content,
            imgUrl = articleRequest.imgUrl
        )
    }

    private fun toDomain(articleEntity: ArticleEntity): Article {
        return Article(
            id = articleEntity.id,
            title = articleEntity.title,
            tag = articleEntity.tag,
            hardness = articleEntity.hardness,
            latitude = articleEntity.latitude,
            content = articleEntity.content,
            createdAt = articleEntity.createdAt,
            imgUrl = articleEntity.imgUrl
        )
    }

    private fun toEntity(article: Article): ArticleEntity {
        return ArticleEntity(
            title = article.title,
            tag = article.tag,
            hardness = article.latitude,
            latitude = article.hardness,
            content = article.content,
            createdAt = article.createdAt,
            imgUrl = article.imgUrl
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
                articleRepository.findByTagEquals(tag) ?: throw CustomException(ArticleErrorCode.NOT_FOUND)
            )
        )
    }

    fun getAll(): BaseResponse<List<Article>> {
        return BaseResponse(
            message = "아티클들 불러오기 성공",
            data = articleRepository.findAll().map { toDomain(it) }
        )
    }



}