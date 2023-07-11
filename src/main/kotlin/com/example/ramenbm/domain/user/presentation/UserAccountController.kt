package com.example.ramenbm.domain.user.presentation

import com.example.ramenbm.domain.ramen.presentation.data.response.RamenTradeListResponse
import com.example.ramenbm.domain.ramen.util.RamenTradeConverter
import com.example.ramenbm.domain.user.presentation.data.response.UserInfoResponse
import com.example.ramenbm.domain.user.service.UserAccountService
import com.example.ramenbm.domain.user.util.AccountConverter
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserAccountController(
	private val userAccountService: UserAccountService,
	private val accountConverter: AccountConverter,
	private val ramenTradeConverter: RamenTradeConverter
) {

	@GetMapping("/{idx}")
	fun findUserByIdx(@PathVariable idx: Long): ResponseEntity<UserInfoResponse> =
		userAccountService.findUserByIdx(idx)
			.let { accountConverter.toResponse(it) }
			.let { ResponseEntity.ok(it) }

	@GetMapping("/my/ramen")
	fun findMyRamenTradeByUser(): ResponseEntity<RamenTradeListResponse> =
		userAccountService.findMyRamenTradeByUser()
			.let { ramenTradeConverter.toListResponse(it) }
			.let { ResponseEntity.ok(it) }

//	@GetMapping("/my/ramen")
//	fun findMyRamenTradeByUser(): ResponseEntity<RamenTradeListResponse> {
//		val b = userAccountService.findMyRamenTradeByUser()
//		val a = ramenTradeConverter.toListResponse(b)
//		println("askjbfaljdbfalsjdfboadsbosdifblasidfbalsdbfasudfbaldsbflsdifbl")
//		return ResponseEntity.ok(a)
//	}
}