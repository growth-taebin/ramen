package com.example.ramenbm.domain.user.util.impl

import com.example.ramenbm.domain.user.entity.User
import com.example.ramenbm.domain.user.presentation.data.dto.UserDto
import com.example.ramenbm.domain.user.presentation.data.dto.UserQueryDto
import com.example.ramenbm.domain.user.presentation.data.request.SignUpRequest
import com.example.ramenbm.domain.user.presentation.data.response.UserInfoResponse
import com.example.ramenbm.domain.user.type.Authority
import com.example.ramenbm.domain.user.util.AccountConverter
import org.springframework.stereotype.Component

@Component
class AccountConverterImpl : AccountConverter {

	override fun toDto(request: SignUpRequest): UserDto =
		UserDto(request.email, request.password, request.name, request.discord)

	override fun toEntity(dto: UserDto, encodePassword: String): User =
		User(dto.email, dto.password, dto.name, dto.discord, Authority.ROLE_USER)

	override fun toQueryDto(user: User): UserQueryDto =
		UserQueryDto(user.idx, user.name, user.discord)

	override fun toResponse(dto: UserQueryDto): UserInfoResponse =
		UserInfoResponse(dto.name, dto.discord)

}