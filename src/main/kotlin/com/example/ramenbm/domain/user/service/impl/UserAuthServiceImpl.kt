package com.example.ramenbm.domain.user.service.impl

import com.example.ramenbm.domain.user.exception.*
import com.example.ramenbm.domain.user.presentation.data.dto.request.SignInRequest
import com.example.ramenbm.domain.user.presentation.data.dto.request.SignUpRequest
import com.example.ramenbm.domain.user.presentation.data.dto.request.toEntity
import com.example.ramenbm.domain.user.presentation.data.dto.response.TokenResponse
import com.example.ramenbm.domain.user.repository.RefreshTokenRepository
import com.example.ramenbm.domain.user.repository.UserRepository
import com.example.ramenbm.domain.user.service.UserAuthService
import com.example.ramenbm.global.security.jwt.TokenParser
import com.example.ramenbm.global.security.jwt.TokenProvider
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserAuthServiceImpl(
    private val userRepository: UserRepository,
    private val refreshTokenRepository: RefreshTokenRepository,
    private val passwordEncoder: PasswordEncoder,
    private val tokenProvider: TokenProvider,
    private val tokenParser: TokenParser
) : UserAuthService {

    @Transactional(rollbackFor = [Exception::class])
    override fun signup(request: SignUpRequest): Long {
        if (userRepository.existsByEmail(request.email)) {
            throw DuplicateEmailException()
        }
        return userRepository.save(request.toEntity(passwordEncoder.encode(request.password))).idx
    }

    @Transactional(rollbackFor = [Exception::class])
    override fun signin(request: SignInRequest): TokenResponse {
        val user = userRepository.findByEmail(request.email) ?: throw UserNotFoundException()
        if (!passwordEncoder.matches(request.password, user.password)) {
            throw PasswordNotCorrectException()
        }
        return tokenProvider.generate(request.email)
    }

    @Transactional(rollbackFor = [Exception::class])
    override fun reissueToken(refreshToken: String): TokenResponse {
        val parsedRefreshToken = tokenParser.parseRefreshToken(refreshToken) ?: throw InvalidTokenException()
        val refreshTokenEntity =
            refreshTokenRepository.findByIdOrNull(parsedRefreshToken) ?: throw ExpiredRefreshTokenException()
        val user = userRepository.findByEmail(refreshTokenEntity.email) ?: throw UserNotFoundException()

        if (refreshTokenRepository.existsById(parsedRefreshToken)) {
            refreshTokenRepository.deleteById(parsedRefreshToken)
        }

        return tokenProvider.generate(user.email)
    }

}