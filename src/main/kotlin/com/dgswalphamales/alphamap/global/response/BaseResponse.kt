package com.dgswalphamales.alphamap.global.response

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class BaseResponse<T> (

    val status: Int,
    val message: String,
    val data: T? = null

)

