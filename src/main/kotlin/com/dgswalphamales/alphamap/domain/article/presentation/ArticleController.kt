package com.dgswalphamales.alphamap.domain.article.presentation

import com.dgswalphamales.alphamap.domain.article.domain.model.Article
import com.dgswalphamales.alphamap.domain.article.presentation.dto.request.ArticleRequest
import com.dgswalphamales.alphamap.domain.article.service.ArticleService
import com.dgswalphamales.alphamap.global.response.BaseResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/article")
class ArticleController(
    private val articleService: ArticleService
) {

    @PostMapping
    fun create(
        @RequestBody articleRequest: ArticleRequest
    ){
        articleService.creat(articleRequest)
    }

    @GetMapping("/{tag}")
    fun getByTag(
        @PathVariable("tag") tag: String
    ): BaseResponse<Article>{
        return articleService.get(tag)
    }

    @GetMapping("/all")
    fun getAll(): BaseResponse<List<Article>>{
        return articleService.getAll()
    }

}