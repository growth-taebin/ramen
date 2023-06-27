package com.example.ramenbm.domain.ramen.presentation.data.request

import com.example.ramenbm.domain.ramen.entity.RamenTrade
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class WriteRamenTradeRequest(
    @field:NotBlank
    val title: String,
    @field:NotNull
    val count: Int,
    @field:NotBlank
    val price: Int
)

