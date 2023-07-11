package com.example.ramenbm.domain.user.util

import com.example.ramenbm.domain.user.entity.User
import com.example.ramenbm.domain.user.presentation.data.dto.UserDto
import com.example.ramenbm.domain.user.presentation.data.dto.UserQueryDto
import com.example.ramenbm.domain.user.presentation.data.request.SignUpRequest
import com.example.ramenbm.domain.user.presentation.data.response.UserInfoResponse
import com.example.ramenbm.domain.user.type.Authority

interface AccountConverter {

	fun toDto(request: SignUpRequest): UserDto

	fun toEntity(dto: UserDto, encodePassword: String): User

	fun toQueryDto(user: User): UserQueryDto

	fun toResponse(dto: UserQueryDto): UserInfoResponse

}