package com.example.ramenbm.domain.user.service.impl

import com.example.ramenbm.domain.ramen.presentation.data.dto.RamenTradeListQueryDto
import com.example.ramenbm.domain.ramen.repository.RamenTradeRepository
import com.example.ramenbm.domain.ramen.util.RamenTradeConverter
import com.example.ramenbm.domain.user.presentation.data.dto.UserQueryDto
import com.example.ramenbm.domain.user.service.UserAccountService
import com.example.ramenbm.domain.user.util.AccountConverter
import com.example.ramenbm.domain.user.util.UserUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserAccountServiceImpl(
	private val userUtil: UserUtil,
	private val accountConverter: AccountConverter,
	private val ramenTradeRepository: RamenTradeRepository,
	private val ramenTradeConverter: RamenTradeConverter
) : UserAccountService {

	@Transactional(readOnly = true, rollbackFor = [Exception::class])
	override fun findUserByIdx(idx: Long): UserQueryDto =
		userUtil.findUserByIdx(idx)
			.let { accountConverter.toQueryDto(it) }

	@Transactional(readOnly = true, rollbackFor = [Exception::class])
	override fun findMyRamenTradeByUser(): RamenTradeListQueryDto {
		val user = userUtil.currentUser()
		ramenTradeRepository.findRamenTradeByUser(user)
			.let { ramenTradeConverter.toListQueryDto(it) }
			.let { return RamenTradeListQueryDto(listOf(it)) }
	}

}