package com.example.ramenbm.domain.ramen.presentation.data.dto

import com.example.ramenbm.domain.user.entity.User

data class RamenTradeDto(
    val title: String,
    val count: Int,
    val price: Int,
    val content: String,
)
