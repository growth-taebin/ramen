package com.example.ramenbm.global.exception.enumType

enum class ErrorCode(
        val message: String,
        val status: Int
) {

    DUPLICATE_EMAIL("중복된 이메일 입니다", 409),
    USER_NOT_FOUND("유저를 찾을 수 없습니다", 404),

    ACCESS_TOKEN_EXPIRED("만료된 accessToken 입니다.", 401),
    INVALID_TOKEN("유효하지 않은 토큰입니다.", 401)
}