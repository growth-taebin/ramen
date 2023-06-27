package com.example.ramenbm.domain.ramen.service

import com.example.ramenbm.domain.ramen.presentation.data.dto.RamenTradeDto

interface RamenTradeService {

    fun write(dto: RamenTradeDto): Long
}