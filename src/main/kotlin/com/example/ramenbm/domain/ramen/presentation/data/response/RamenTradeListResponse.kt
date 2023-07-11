package com.example.ramenbm.domain.ramen.presentation.data.response

import com.example.ramenbm.domain.ramen.presentation.data.dto.RamenTradeQueryDto

data class RamenTradeListResponse(
	val list: List<RamenTradeQueryDto>
)
