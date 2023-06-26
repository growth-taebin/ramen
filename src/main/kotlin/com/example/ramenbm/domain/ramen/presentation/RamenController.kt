package com.example.ramenbm.domain.ramen.presentation

import com.example.ramenbm.domain.ramen.presentation.data.dto.request.WriteRamenRequest
import com.example.ramenbm.domain.ramen.service.RamenService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/ramen")
class RamenController(
    private val ramenService: RamenService
) {

    @PostMapping
    fun writeRamen(@RequestBody request: WriteRamenRequest): ResponseEntity<Void> =
        ramenService.write(request)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }
}