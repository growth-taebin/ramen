package com.example.ramenbm.domain.user.service

import com.example.ramenbm.domain.user.exception.DuplicateEmailException
import com.example.ramenbm.domain.user.presentation.data.dto.request.SignUpRequest
import com.example.ramenbm.domain.user.presentation.data.dto.request.toEntity
import com.example.ramenbm.domain.user.repository.UserRepository
import com.example.ramenbm.global.annotation.ServiceWithTransaction
import org.springframework.security.crypto.password.PasswordEncoder

@ServiceWithTransaction
class UserAuthService(
        private val userRepository: UserRepository,
        private val passwordEncoder: PasswordEncoder
) {

    fun signup(request: SignUpRequest) {
        if(userRepository.existsByEmail(request.email)) {
            throw DuplicateEmailException()
        }
        userRepository.save(request.toEntity(passwordEncoder.encode(request.password)))

    }
}