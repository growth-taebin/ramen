package com.example.ramenbm.domain.user.service

import com.example.ramenbm.domain.ramen.presentation.data.dto.RamenTradeListQueryDto
import com.example.ramenbm.domain.user.presentation.data.dto.UserQueryDto

interface UserAccountService {

	fun findUserByIdx(idx: Long): UserQueryDto

	fun findMyRamenTradeByUser(): RamenTradeListQueryDto

}