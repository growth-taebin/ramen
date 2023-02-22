package com.example.ramenbm.domain.user.presentation.data.dto.request

data class SignUpRequest(
        val email: String,
        val password: String,
        val name: String,
        val discord: String
)
