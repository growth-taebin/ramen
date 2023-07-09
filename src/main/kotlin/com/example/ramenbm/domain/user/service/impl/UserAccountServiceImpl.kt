package com.example.ramenbm.domain.user.service.impl

import com.example.ramenbm.domain.user.presentation.data.dto.UserQueryDto
import com.example.ramenbm.domain.user.service.UserAccountService
import com.example.ramenbm.domain.user.util.AccountConverter
import com.example.ramenbm.domain.user.util.UserUtil
import org.springframework.stereotype.Service

@Service
class UserAccountServiceImpl(
	private val userUtil: UserUtil,
	private val accountConverter: AccountConverter
) : UserAccountService {

	override fun findUserByIdx(idx: Long): UserQueryDto =
		userUtil.findUserByIdx(idx)
			.let { accountConverter.toQueryDto(it) }


}