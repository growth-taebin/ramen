package com.example.ramenbm.domain.user.presentation.data.dto.response

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class TokenResponse(
	val accessToken: String,
	val refreshToken: String,
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH-mm-ss")
	val accessTokenExpiredAt: LocalDateTime,
	val refreshTokenExpiredAt: LocalDateTime
)
