package com.example.ramenbm.domain.ramen.util

import com.example.ramenbm.domain.ramen.entity.RamenTrade
import com.example.ramenbm.domain.ramen.presentation.data.dto.DeleteRamenTradeDto
import com.example.ramenbm.domain.ramen.presentation.data.dto.UpdateRamenTradeDto
import com.example.ramenbm.domain.ramen.presentation.data.dto.WriteRamenTradeDto
import com.example.ramenbm.domain.ramen.presentation.data.request.UpdateRamenTradeRequest
import com.example.ramenbm.domain.ramen.presentation.data.request.WriteRamenTradeRequest
import com.example.ramenbm.domain.user.entity.User

interface RamenTradeConverter {

    fun toDto(request: WriteRamenTradeRequest): WriteRamenTradeDto

    fun toDto(idx: Long, request: UpdateRamenTradeRequest): UpdateRamenTradeDto

    fun toDto(idx: Long): DeleteRamenTradeDto

    fun toEntity(dto: WriteRamenTradeDto, user: User): RamenTrade

}