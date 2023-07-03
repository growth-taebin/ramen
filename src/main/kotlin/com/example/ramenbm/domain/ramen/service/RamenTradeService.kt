package com.example.ramenbm.domain.ramen.service

import com.example.ramenbm.domain.ramen.presentation.data.dto.UpdateRamenTradeDto
import com.example.ramenbm.domain.ramen.presentation.data.dto.WriteRamenTradeDto

interface RamenTradeService {

    fun write(dto: WriteRamenTradeDto): Long

    fun update(dto: UpdateRamenTradeDto)

    fun delete(idx: Long)
}