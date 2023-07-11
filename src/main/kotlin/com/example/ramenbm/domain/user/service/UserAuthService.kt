package com.example.ramenbm.domain.user.service

import com.example.ramenbm.domain.user.presentation.data.dto.UserDto
import com.example.ramenbm.domain.user.presentation.data.request.SignInRequest
import com.example.ramenbm.domain.user.presentation.data.request.SignUpRequest
import com.example.ramenbm.domain.user.presentation.data.response.TokenResponse

interface UserAuthService {

	fun signup(dto: UserDto): Long
	fun signin(request: SignInRequest): TokenResponse
	fun reissueToken(refreshToken: String): TokenResponse

}