package com.example.ramenbm.domain.ramen.presentation

import com.example.ramenbm.domain.ramen.presentation.data.request.UpdateRamenTradeRequest
import com.example.ramenbm.domain.ramen.presentation.data.request.WriteRamenTradeRequest
import com.example.ramenbm.domain.ramen.presentation.data.response.RamenTradeListResponse
import com.example.ramenbm.domain.ramen.presentation.data.response.RamenTradeResponse
import com.example.ramenbm.domain.ramen.service.RamenTradeService
import com.example.ramenbm.domain.ramen.util.RamenTradeConverter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
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

	@PatchMapping("/{idx}")
	fun updateRamenTrade(@PathVariable idx: Long, @RequestBody request: UpdateRamenTradeRequest): ResponseEntity<Void> =
		ramenTradeConverter.toDto(idx, request)
			.let { ramenTradeService.update(it) }
			.let { ResponseEntity.ok().build() }

	@DeleteMapping("/{idx}")
	fun deleteRamenTrade(@PathVariable idx: Long): ResponseEntity<Void> =
		ramenTradeService.delete(idx)
			.let { ResponseEntity.status(HttpStatus.RESET_CONTENT).build() }

	@GetMapping
	fun findAllRamenTrade(): ResponseEntity<RamenTradeListResponse> =
		ramenTradeService.findAll()
			.let { ramenTradeConverter.toListResponse(it) }
			.let { ResponseEntity.ok(it) }

	@GetMapping("/{idx}")
	fun findRamenTradeByIdx(@PathVariable idx: Long): ResponseEntity<RamenTradeResponse> =
		ramenTradeService.findRamenTradeById(idx)
			.let { ramenTradeConverter.toResponse(it) }
			.let { ResponseEntity.ok(it) }

}