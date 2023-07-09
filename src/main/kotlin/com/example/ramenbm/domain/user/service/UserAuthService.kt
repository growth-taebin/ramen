package com.example.ramenbm.domain.user.service

import com.example.ramenbm.domain.user.presentation.data.request.SignInRequest
import com.example.ramenbm.domain.user.presentation.data.request.SignUpRequest
import com.example.ramenbm.domain.user.presentation.data.response.TokenResponse

interface UserAuthService {

	fun signup(request: SignUpRequest): Long
	fun signin(request: SignInRequest): TokenResponse
	fun reissueToken(refreshToken: String): TokenResponse

}