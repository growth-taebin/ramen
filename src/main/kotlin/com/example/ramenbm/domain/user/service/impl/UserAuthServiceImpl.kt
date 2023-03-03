package com.example.ramenbm.domain.user.service.impl

import com.example.ramenbm.domain.user.entity.User
import com.example.ramenbm.domain.user.exception.DuplicateEmailException
import com.example.ramenbm.domain.user.exception.PasswordNotCorrectException
import com.example.ramenbm.domain.user.exception.UserNotFoundException
import com.example.ramenbm.domain.user.presentation.data.dto.request.SignInRequest
import com.example.ramenbm.domain.user.presentation.data.dto.request.SignUpRequest
import com.example.ramenbm.domain.user.presentation.data.dto.request.toEntity
import com.example.ramenbm.domain.user.presentation.data.dto.response.SignInResponse
import com.example.ramenbm.domain.user.repository.UserRepository
import com.example.ramenbm.domain.user.service.UserAuthService
import com.example.ramenbm.global.annotation.ServiceWithTransaction
import com.example.ramenbm.global.security.jwt.TokenProvider
import org.springframework.security.crypto.password.PasswordEncoder

@ServiceWithTransaction
class UserAuthServiceImpl(
        private val userRepository: UserRepository,
        private val passwordEncoder: PasswordEncoder,
        private val tokenProvider: TokenProvider
): UserAuthService {

    override fun signup(request: SignUpRequest): Long {
        if (userRepository.existsByEmail(request.email)) {
            throw DuplicateEmailException()
        }
        return userRepository.save(request.toEntity(passwordEncoder.encode(request.password))).idx
    }

    override fun signin(request: SignInRequest): SignInResponse {
        val user: User = userRepository.findByEmail(request.email) ?: throw UserNotFoundException()
        if (!passwordEncoder.matches(request.password, user.password)) {
            throw PasswordNotCorrectException()
        }
        return tokenProvider.generate(request.email)
    }


}