package com.example.ramenbm.domain.ramen.presentation.data.dto

data class UpdateRamenTradeDto(
    val idx: Long,
    val title: String,
    val count: Int,
    val price: Int,
    val content: String
)
