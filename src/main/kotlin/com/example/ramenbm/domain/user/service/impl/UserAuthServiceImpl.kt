package com.example.ramenbm.domain.user.service.impl

import com.example.ramenbm.domain.user.exception.DuplicateEmailException
import com.example.ramenbm.domain.user.presentation.data.dto.request.SignUpRequest
import com.example.ramenbm.domain.user.presentation.data.dto.request.toEntity
import com.example.ramenbm.domain.user.repository.UserRepository
import com.example.ramenbm.domain.user.service.UserAuthService
import com.example.ramenbm.global.annotation.ServiceWithTransaction
import org.springframework.security.crypto.password.PasswordEncoder

@ServiceWithTransaction
class UserAuthServiceImpl(
        private val userRepository: UserRepository,
        private val passwordEncoder: PasswordEncoder
): UserAuthService {

    override fun signup(request: SignUpRequest): Long {
        if (userRepository.existsByEmail(request.email)) {
            throw DuplicateEmailException()
        }
        return userRepository.save(request.toEntity(passwordEncoder.encode(request.password))).idx
    }
}