package com.example.ramenbm.domain.ramen.service.impl

import com.example.ramenbm.domain.ramen.presentation.data.dto.request.WriteRamenRequest
import com.example.ramenbm.domain.ramen.presentation.data.dto.request.toEntity
import com.example.ramenbm.domain.ramen.repository.RamenRepository
import com.example.ramenbm.domain.ramen.service.RamenService
import com.example.ramenbm.domain.user.entity.User
import com.example.ramenbm.domain.user.util.UserUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RamenServiceImpl(
    private val ramenRepository: RamenRepository,
    private val userUtil: UserUtil
): RamenService {

    @Transactional(rollbackFor = [Exception::class])
    override fun write(request: WriteRamenRequest): Long {
        val user: User = userUtil.currentUser()

        return ramenRepository.save(request.toEntity()).idx
    }

}