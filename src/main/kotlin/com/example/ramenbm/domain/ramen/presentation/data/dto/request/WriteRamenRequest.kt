package com.example.ramenbm.domain.ramen.presentation.data.dto.request

import com.example.ramenbm.domain.ramen.entity.Ramen

data class WriteRamenRequest(
    val title: String,
    val count: Int,
    val price: String
)

fun WriteRamenRequest.toEntity() =
    Ramen(
        title = title,
        count = count,
        price = price
    )
