package com.example.ramenbm.domain.user.presentation

import com.example.ramenbm.domain.user.presentation.data.dto.request.SignInRequest
import com.example.ramenbm.domain.user.presentation.data.dto.request.SignUpRequest
import com.example.ramenbm.domain.user.presentation.data.dto.response.SignInResponse
import com.example.ramenbm.domain.user.service.UserAuthService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("auth")
class UserAuthController(
        private val userAuthService: UserAuthService
) {

    @PostMapping("/signup")
    fun signup(@RequestBody request: SignUpRequest): ResponseEntity<Void> =
            userAuthService.signup(request)
                    .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @PostMapping("/signin")
    fun signIn(@RequestBody request: SignInRequest): ResponseEntity<SignInResponse> =
            userAuthService.signin(request)
                    .let { ResponseEntity.ok(it) }
}