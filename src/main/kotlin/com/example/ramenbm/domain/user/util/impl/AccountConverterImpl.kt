package com.example.ramenbm.domain.user.util.impl

import com.example.ramenbm.domain.user.entity.User
import com.example.ramenbm.domain.user.presentation.data.dto.UserQueryDto
import com.example.ramenbm.domain.user.util.AccountConverter

class AccountConverterImpl : AccountConverter {

	override fun toQueryDto(user: User): UserQueryDto =
		UserQueryDto(user.idx, user.name, user.discord)

}