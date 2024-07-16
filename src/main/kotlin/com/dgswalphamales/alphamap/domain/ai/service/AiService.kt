package com.dgswalphamales.alphamap.domain.ai.service

import com.dgswalphamales.alphamap.global.response.BaseResponse
import org.springframework.ai.openai.OpenAiChatModel
import org.springframework.stereotype.Service

@Service
class AiService(
    private val openAiChatModel: OpenAiChatModel
) {

    fun get(
        message: String
    ): BaseResponse<String> {

        val messages = openAiChatModel.call(message)

        println()
        return BaseResponse(
            message = "mes",
            data = messages
        )
    }

}