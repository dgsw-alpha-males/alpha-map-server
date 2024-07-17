package com.dgswalphamales.alphamap.domain.article.exception

import com.dgswalphamales.alphamap.global.exception.CustomErrorCode
import org.springframework.http.HttpStatus

enum class ArticleErrorCode (
    override val status: HttpStatus,
    override val state: String,
    override val message: String,
): CustomErrorCode {

    NOT_FOUND(HttpStatus.NOT_FOUND, "NOT_FOUND", "아티클을 찾을 수 없습니다."),
    MEDIA_TYPE_ERROR(HttpStatus.UNSUPPORTED_MEDIA_TYPE, "UNSUPPORTED_MEDIA_TYPE", "요청을 다시 확인해주세요."),

}