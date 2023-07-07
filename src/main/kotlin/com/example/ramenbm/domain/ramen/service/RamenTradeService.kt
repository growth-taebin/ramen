package com.example.ramenbm.domain.ramen.service

import com.example.ramenbm.domain.ramen.presentation.data.dto.*

interface RamenTradeService {

    fun write(dto: WriteRamenTradeDto): Long

    fun update(dto: UpdateRamenTradeDto)

    fun delete(idx: Long)

    fun findAll(): RamenTradeListQueryDto

    fun findRamenTradeById(idx: Long): RamenTradeDetailQueryDto

}