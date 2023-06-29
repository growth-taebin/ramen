package com.example.ramenbm.domain.ramen.util.impl

import com.example.ramenbm.domain.ramen.entity.RamenTrade
import com.example.ramenbm.domain.ramen.presentation.data.dto.UpdateRamenTradeDto
import com.example.ramenbm.domain.ramen.presentation.data.dto.WriteRamenTradeDto
import com.example.ramenbm.domain.ramen.presentation.data.request.UpdateRamenTradeRequest
import com.example.ramenbm.domain.ramen.presentation.data.request.WriteRamenTradeRequest
import com.example.ramenbm.domain.ramen.util.RamenTradeConverter
import com.example.ramenbm.domain.user.entity.User
import org.springframework.stereotype.Component

@Component
class RamenTradeConverterImpl : RamenTradeConverter {

    override fun toDto(request: WriteRamenTradeRequest): WriteRamenTradeDto =
        WriteRamenTradeDto(request.title, request.count, request.price, request.content)

    override fun toDto(idx: Long, request: UpdateRamenTradeRequest): UpdateRamenTradeDto =
        UpdateRamenTradeDto(idx, request.title, request.count, request.price, request.content)

    override fun toEntity(dto: WriteRamenTradeDto, user: User): RamenTrade =
        RamenTrade(dto.title, dto.count, dto.price, dto.content, user)
}