package com.example.ramenbm.domain.user.service.impl

import com.example.ramenbm.domain.user.exception.*
import com.example.ramenbm.domain.user.presentation.data.dto.request.SignInRequest
import com.example.ramenbm.domain.user.presentation.data.dto.request.SignUpRequest
import com.example.ramenbm.domain.user.presentation.data.dto.request.toEntity
import com.example.ramenbm.domain.user.presentation.data.dto.response.SignInResponse
import com.example.ramenbm.domain.user.repository.UserRepository
import com.example.ramenbm.domain.user.service.UserAuthService
import com.example.ramenbm.global.annotation.ServiceWithTransaction
import com.example.ramenbm.global.security.jwt.TokenParser
import com.example.ramenbm.global.security.jwt.TokenProvider
import org.springframework.security.crypto.password.PasswordEncoder

@ServiceWithTransaction
class UserAuthServiceImpl(
        private val userRepository: UserRepository,
        private val passwordEncoder: PasswordEncoder,
        private val tokenProvider: TokenProvider,
        private val tokenParser: TokenParser
): UserAuthService {

    override fun signup(request: SignUpRequest): Long {
        if (userRepository.existsByEmail(request.email)) {
            throw DuplicateEmailException()
        }
        return userRepository.save(request.toEntity(passwordEncoder.encode(request.password))).idx
    }

    override fun signin(request: SignInRequest): SignInResponse {
        val user = userRepository.findByEmail(request.email) ?: throw UserNotFoundException()
        if (!passwordEncoder.matches(request.password, user.password)) {
            throw PasswordNotCorrectException()
        }
        return tokenProvider.generate(request.email)
    }

    override fun reissueToken(refreshToken: String): SignInResponse {
        val parsedRefreshToken = tokenParser.parseRefreshToken(refreshToken) ?: throw InvalidTokenException()
        val email = tokenParser.exactEmailFromRefreshToken(refreshToken)

        if (tokenParser.isRefreshTokenExpired(parsedRefreshToken)) {
            throw ExpiredRefreshTokenException()
        }
        if(userRepository.existsByEmail(email)) {
            throw UserNotFoundException()
        }
        return tokenProvider.generate(email)
    }

}