package com.example.ramenbm.domain.user.presentation.data.dto.request

import com.example.ramenbm.domain.user.entity.User

data class SignUpRequest(
        val email: String,
        val password: String,
        val name: String,
        val discord: String,
)

fun SignUpRequest.toEntity(encodePassword: String) =
        User(
                email = email,
                password = encodePassword,
                name = name,
                discord = discord
        )


