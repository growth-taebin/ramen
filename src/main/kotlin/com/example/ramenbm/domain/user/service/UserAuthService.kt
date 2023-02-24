package com.example.ramenbm.domain.user.service

import com.example.ramenbm.domain.user.entity.User
import com.example.ramenbm.domain.user.exception.DuplicateEmailException
import com.example.ramenbm.domain.user.presentation.data.dto.request.SignUpRequest
import com.example.ramenbm.domain.user.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserAuthService(
        private val userRepository: UserRepository,
        private val passwordEncoder: PasswordEncoder
) {

    @Transactional(rollbackFor = [Exception::class])
    fun signup(request: SignUpRequest) {
        if(userRepository.existsByEmail(request.email)) {
            throw DuplicateEmailException()
        }
        userRepository.save(User(id = -1, request.email, passwordEncoder.encode(request.password), request.name, request.discord))

    }
}