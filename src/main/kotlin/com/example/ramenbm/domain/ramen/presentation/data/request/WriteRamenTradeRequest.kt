package com.example.ramenbm.domain.ramen.presentation.data.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class WriteRamenTradeRequest(
    @field:NotBlank
    val title: String,
    @field:NotNull
    val count: Int,
    @field:NotNull
    val price: Int,
    @field:NotBlank
    val content: String
)

