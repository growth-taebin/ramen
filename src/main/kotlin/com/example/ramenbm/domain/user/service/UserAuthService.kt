package com.example.ramenbm.domain.user.service

import com.example.ramenbm.domain.user.presentation.data.dto.request.SignInRequest
import com.example.ramenbm.domain.user.presentation.data.dto.request.SignUpRequest
import com.example.ramenbm.domain.user.presentation.data.dto.response.SignInResponse

interface UserAuthService {

    fun signup(request: SignUpRequest): Long
    fun signin(request: SignInRequest): SignInResponse
    fun reissueToken(refreshToken: String): SignInResponse
}