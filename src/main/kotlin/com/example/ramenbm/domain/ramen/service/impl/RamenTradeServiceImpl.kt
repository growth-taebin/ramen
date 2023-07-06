package com.example.ramenbm.domain.ramen.service.impl

import com.example.ramenbm.domain.ramen.exception.RamenTradeNotFoundException
import com.example.ramenbm.domain.ramen.presentation.data.dto.RamenTradeListQueryDto
import com.example.ramenbm.domain.ramen.presentation.data.dto.UpdateRamenTradeDto
import com.example.ramenbm.domain.ramen.presentation.data.dto.WriteRamenTradeDto
import com.example.ramenbm.domain.ramen.repository.RamenTradeRepository
import com.example.ramenbm.domain.ramen.service.RamenTradeService
import com.example.ramenbm.domain.ramen.util.RamenTradeConverter
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
    override fun write(dto: WriteRamenTradeDto): Long {
        val user = userUtil.currentUser()
        ramenTradeConverter.toEntity(dto, user)
            .let { return ramenRepository.save(it).idx }
    }

    @Transactional(rollbackFor = [Exception::class])
    override fun update(dto: UpdateRamenTradeDto) {
        val ramenTrade = ramenRepository.findRamenTradeByIdx(dto.idx) ?: throw RamenTradeNotFoundException()
        ramenTrade.updateRamenTrade(dto.title, dto.count, dto.price, dto.content)
    }

    override fun delete(idx: Long) =
        ramenRepository.deleteById(idx)


    override fun findAll(): RamenTradeListQueryDto =
        ramenRepository.findAll()
            .map { ramenTradeConverter.toQueryDto(it) }
            .let { RamenTradeListQueryDto(it) }


}