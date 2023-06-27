package com.example.ramenbm.domain.ramen.util

import com.example.ramenbm.domain.ramen.entity.RamenTrade
import com.example.ramenbm.domain.ramen.presentation.data.dto.RamenTradeDto
import com.example.ramenbm.domain.ramen.presentation.data.request.WriteRamenTradeRequest
import com.example.ramenbm.domain.user.entity.User

interface RamenTradeConverter {

    fun toDto(request: WriteRamenTradeRequest): RamenTradeDto
    fun toEntity(dto: RamenTradeDto): RamenTrade
}