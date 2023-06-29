package com.example.ramenbm.domain.user.util.impl

import com.example.ramenbm.domain.user.entity.User
import com.example.ramenbm.domain.user.exception.UserNotFoundException
import com.example.ramenbm.domain.user.repository.UserRepository
import com.example.ramenbm.domain.user.util.UserUtil
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class UserUtilImpl(
    private val userRepository: UserRepository
) : UserUtil {

    @Transactional(readOnly = true, rollbackFor = [Exception::class])
    override fun currentUser(): User {
        val email = SecurityContextHolder.getContext().authentication.name
        return userRepository.findByEmail(email)
            ?: throw UserNotFoundException()
    }

}