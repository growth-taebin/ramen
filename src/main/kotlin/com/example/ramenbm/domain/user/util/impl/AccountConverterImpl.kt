package com.example.ramenbm.domain.user.util.impl

import com.example.ramenbm.domain.user.entity.User
import com.example.ramenbm.domain.user.presentation.data.dto.UserQueryDto
import com.example.ramenbm.domain.user.presentation.data.response.UserInfoResponse
import com.example.ramenbm.domain.user.util.AccountConverter
import org.springframework.stereotype.Component

@Component
class AccountConverterImpl : AccountConverter {

	override fun toQueryDto(user: User): UserQueryDto =
		UserQueryDto(user.idx, user.name, user.discord)

	override fun toResponse(dto: UserQueryDto): UserInfoResponse =
		UserInfoResponse(dto.name, dto.discord)

}