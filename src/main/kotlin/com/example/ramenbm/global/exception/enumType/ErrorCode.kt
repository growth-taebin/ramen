package com.example.ramenbm.global.exception.enumType

enum class ErrorCode(
        val message: String,
        val status: Int
) {

    DUPLICATE_EMAIL("중복된 이메일 입니다", 409),
    USER_NOT_FOUND("유저를 찾을 수 없습니다", 404),
    PASSWORD_NOT_CORRECT("비밀번호가 일치하지 않습니다.", 400),

    ACCESS_TOKEN_EXPIRED("만료된 accessToken 입니다.", 401),
    INVALID_TOKEN("유효하지 않은 토큰입니다.", 401),
    REFRESH_TOKEN_EXPIRED("만료된 refreshToken 입니다.", 401),

    RAMEN_TRADE_NOT_FOUND("글을 찾을 수 없습니다.", 404)
}