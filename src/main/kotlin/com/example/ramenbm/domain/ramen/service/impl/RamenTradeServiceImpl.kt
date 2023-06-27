package com.example.ramenbm.domain.ramen.service.impl

import com.example.ramenbm.domain.ramen.presentation.data.dto.RamenTradeDto
import com.example.ramenbm.domain.ramen.repository.RamenTradeRepository
import com.example.ramenbm.domain.ramen.service.RamenTradeService
import com.example.ramenbm.domain.ramen.util.RamenTradeConverter
import com.example.ramenbm.domain.user.entity.User
import com.example.ramenbm.domain.user.util.UserUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RamenTradeServiceImpl(
    private val ramenRepository: RamenTradeRepository,
    private val userUtil: UserUtil,
    private val ramenTradeConverter: RamenTradeConverter
): RamenTradeService {

    @Transactional(rollbackFor = [Exception::class])
    override fun write(dto: RamenTradeDto): Long {
        val user = userUtil.currentUser()
        ramenTradeConverter.toEntity(dto, user)
            .let { return ramenRepository.save(it).idx }
    }

}