package com.dgswalphamales.alphamap.domain.ai.presentation


import com.dgswalphamales.alphamap.domain.ai.presentation.dto.request.MessageRequest
import com.dgswalphamales.alphamap.domain.ai.service.AiService
import com.dgswalphamales.alphamap.global.response.BaseResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/ai")
@RestController
class AiController(
    private val aiService: AiService
) {
    @PostMapping("/chat")
    fun chat(
        @RequestBody message: MessageRequest,
    ): BaseResponse<String> {
        return aiService.get(message)
    }

}