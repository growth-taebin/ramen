package com.example.ramenbm.domain.user.presentation.data.request

import com.example.ramenbm.domain.user.entity.User
import com.example.ramenbm.domain.user.type.Authority

data class SignUpRequest(
	val email: String,
	val password: String,
	val name: String,
	val discord: String,
)


