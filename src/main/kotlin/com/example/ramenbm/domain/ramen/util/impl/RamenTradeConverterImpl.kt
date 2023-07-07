package com.example.ramenbm.domain.ramen.util.impl

import com.example.ramenbm.domain.ramen.entity.RamenTrade
import com.example.ramenbm.domain.ramen.presentation.data.dto.*
import com.example.ramenbm.domain.ramen.presentation.data.request.UpdateRamenTradeRequest
import com.example.ramenbm.domain.ramen.presentation.data.request.WriteRamenTradeRequest
import com.example.ramenbm.domain.ramen.presentation.data.response.RamenTradeListResponse
import com.example.ramenbm.domain.ramen.presentation.data.response.RamenTradeResponse
import com.example.ramenbm.domain.ramen.util.RamenTradeConverter
import com.example.ramenbm.domain.user.entity.User
import org.springframework.stereotype.Component

@Component
class RamenTradeConverterImpl : RamenTradeConverter {

    override fun toDto(request: WriteRamenTradeRequest): WriteRamenTradeDto =
            WriteRamenTradeDto(request.title, request.count, request.price, request.content)

    override fun toDto(idx: Long, request: UpdateRamenTradeRequest): UpdateRamenTradeDto =
            UpdateRamenTradeDto(idx, request.title, request.count, request.price, request.content)

    override fun toDto(idx: Long): RamenTradeDto =
            RamenTradeDto(idx, "", null, null, "")

    override fun toEntity(dto: WriteRamenTradeDto, user: User): RamenTrade =
            RamenTrade(dto.title, dto.count, dto.price, dto.content, user)

    override fun toQueryDto(ramenTrade: RamenTrade): RamenTradeDetailQueryDto =
            RamenTradeDetailQueryDto(ramenTrade.idx, ramenTrade.title, ramenTrade.count, ramenTrade.price, ramenTrade.content, ramenTrade.user.name, ramenTrade.user.discord)

    override fun toListQueryDto(ramenTrade: RamenTrade): RamenTradeQueryDto =
            RamenTradeQueryDto(ramenTrade.idx, ramenTrade.title, ramenTrade.user.name, ramenTrade.user.discord)

    override fun toResponse(ramenTradeDetailQueryDto: RamenTradeDetailQueryDto): RamenTradeResponse =
            RamenTradeResponse(ramenTradeDetailQueryDto.idx, ramenTradeDetailQueryDto.title, ramenTradeDetailQueryDto.count, ramenTradeDetailQueryDto.price, ramenTradeDetailQueryDto.content, ramenTradeDetailQueryDto.userName, ramenTradeDetailQueryDto.discord)
    override fun toListResponse(dto: RamenTradeListQueryDto): RamenTradeListResponse =
            RamenTradeListResponse(dto.list)

}