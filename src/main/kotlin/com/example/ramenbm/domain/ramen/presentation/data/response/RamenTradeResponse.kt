package com.example.ramenbm.domain.ramen.presentation.data.response

data class RamenTradeResponse(
	val idx: Long,
	val title: String,
	val count: Int,
	val price: Int?,
	val content: String,
	val userName: String,
	val discord: String
)
