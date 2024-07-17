package com.dgswalphamales.alphamap.domain.ai.service

import com.dgswalphamales.alphamap.global.response.BaseResponse
import org.springframework.ai.chat.prompt.PromptTemplate
import org.springframework.ai.openai.OpenAiChatModel
import org.springframework.stereotype.Service
import java.util.Map


@Service
class AiService(
    private val openAiChatModel: OpenAiChatModel,
) {

    fun get(
        message: String,
    ): BaseResponse<String> {

        val promptTemplate = PromptTemplate("너는 사회문제를 잘 알고있는 사회문제 전문가야. 사용자가 너한테 사회 문제에 관련해서 질문을 하면 너는 전문가처럼 답변을 진행해줘야해. 사용자의 질문은 {question}이야 ")

        val prompt = promptTemplate.create(Map.of<String, Any>("question", message))


        return BaseResponse(
            message = "답변 생성 성공",
            data =
            openAiChatModel.call(prompt).result.output.content
        )
    }

}