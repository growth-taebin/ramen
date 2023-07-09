package com.example.ramenbm.domain.user.util

import com.example.ramenbm.domain.user.entity.User
import com.example.ramenbm.domain.user.presentation.data.dto.UserQueryDto

interface AccountConverter {

	fun toQueryDto(user: User): UserQueryDto

}