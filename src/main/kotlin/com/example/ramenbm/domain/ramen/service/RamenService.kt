package com.example.ramenbm.domain.ramen.service

import com.example.ramenbm.domain.ramen.presentation.data.dto.request.WriteRamenRequest

interface RamenService {

    fun write(request: WriteRamenRequest): Long
}