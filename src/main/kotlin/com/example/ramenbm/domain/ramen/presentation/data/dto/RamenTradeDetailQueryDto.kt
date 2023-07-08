package com.example.ramenbm.domain.ramen.presentation.data.dto

data class RamenTradeDetailQueryDto(
	val idx: Long,
	val title: String,
	val count: Int,
	val price: Int,
	val content: String,
	val userName: String,
	val discord: String
)
