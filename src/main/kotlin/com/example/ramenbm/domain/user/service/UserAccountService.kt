package com.example.ramenbm.domain.user.service

import com.example.ramenbm.domain.user.presentation.data.dto.UserQueryDto

interface UserAccountService {

	fun findUserByIdx(idx: Long): UserQueryDto

}