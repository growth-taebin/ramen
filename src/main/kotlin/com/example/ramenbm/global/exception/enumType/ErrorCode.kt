package com.example.ramenbm.global.exception.enumType

enum class ErrorCode(
        val message: String,
        val status: Int
) {

    DUPLICATE_EMAIL("중복된 이메일 입니다", 409)
}