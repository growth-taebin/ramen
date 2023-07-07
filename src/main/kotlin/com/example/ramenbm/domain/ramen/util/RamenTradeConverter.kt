package com.example.ramenbm.domain.ramen.util

import com.example.ramenbm.domain.ramen.entity.RamenTrade
import com.example.ramenbm.domain.ramen.presentation.data.dto.*
import com.example.ramenbm.domain.ramen.presentation.data.request.UpdateRamenTradeRequest
import com.example.ramenbm.domain.ramen.presentation.data.request.WriteRamenTradeRequest
import com.example.ramenbm.domain.ramen.presentation.data.response.RamenTradeListResponse
import com.example.ramenbm.domain.ramen.presentation.data.response.RamenTradeResponse
import com.example.ramenbm.domain.user.entity.User

interface RamenTradeConverter {

    fun toDto(request: WriteRamenTradeRequest): WriteRamenTradeDto

    fun toDto(idx: Long, request: UpdateRamenTradeRequest): UpdateRamenTradeDto

    fun toDto(idx: Long): RamenTradeDto

    fun toEntity(dto: WriteRamenTradeDto, user: User): RamenTrade

    fun toQueryDto(ramenTrade: RamenTrade): RamenTradeDetailQueryDto

    fun toListQueryDto(ramenTrade: RamenTrade): RamenTradeQueryDto

    fun toResponse(ramenTradeDetailQueryDto: RamenTradeDetailQueryDto): RamenTradeResponse

    fun toListResponse(dto: RamenTradeListQueryDto): RamenTradeListResponse

}