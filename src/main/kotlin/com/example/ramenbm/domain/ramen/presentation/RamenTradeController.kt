package com.example.ramenbm.domain.ramen.presentation

import com.example.ramenbm.domain.ramen.presentation.data.request.WriteRamenTradeRequest
import com.example.ramenbm.domain.ramen.service.RamenTradeService
import com.example.ramenbm.domain.ramen.util.RamenTradeConverter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/ramen")
class RamenTradeController(
    private val ramenTradeService: RamenTradeService,
    private val ramenTradeConverter: RamenTradeConverter
) {

    @PostMapping
    fun writeRamenTrade(@RequestBody request: WriteRamenTradeRequest): ResponseEntity<Void> =
        ramenTradeConverter.toDto(request)
            .let { ramenTradeService.write(it) }
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }
}