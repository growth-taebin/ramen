package com.example.ramenbm.domain.user.service

import com.example.ramenbm.domain.user.presentation.data.dto.request.SignUpRequest

interface UserAuthService {

    fun signup(request: SignUpRequest): Long
}