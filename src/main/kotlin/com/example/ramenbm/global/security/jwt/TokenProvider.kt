package com.example.ramenbm.global.security.jwt

import com.example.ramenbm.domain.user.entity.RefreshToken
import com.example.ramenbm.domain.user.presentation.data.dto.response.SignInResponse
import com.example.ramenbm.domain.user.repository.RefreshTokenRepository
import com.example.ramenbm.global.security.authentication.AuthDetailsService
import com.example.ramenbm.global.security.jwt.properties.JwtProperties
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.security.Key
import java.time.LocalDateTime
import java.util.*
import javax.servlet.http.HttpServletRequest

@Component
class TokenProvider(
        private val jwtProperties: JwtProperties,
        private val refreshTokenRepository: RefreshTokenRepository,
        private val authDetailsService: AuthDetailsService
) {

    companion object {
        const val ACCESS_TYPE = "access"
        const val REFRESH_TYPE = "refresh"
        const val ACCESS_EXP = 60L * 60 * 3 //3 hour
        const val REFRESH_EXP = 60L * 60 * 24 * 7 //1 week
        const val TOKEN_PREFIX = "Bearer "
    }

    @Transactional(rollbackFor = [Exception::class])
    fun generate(email: String): SignInResponse {
        val accessToken = generateAccessToken(email)
        val refreshToken = generateRefreshToken(email)
        refreshTokenRepository.save(RefreshToken(email, refreshToken, REFRESH_EXP))
        return SignInResponse(accessToken, refreshToken, getAccessTokenExpiredAt())
    }

    fun parseAccessToken(request: HttpServletRequest): String? =
            request.getHeader("Authorization")
                    .let { it ?: return null }
                    .let { if (it.startsWith(TOKEN_PREFIX)) it.replace(TOKEN_PREFIX, "") else null }

    fun parseRefreshToken(token: String): String? =
            if (token.startsWith(TOKEN_PREFIX)) token.replace(TOKEN_PREFIX, "") else null

    fun getTokenBody(token: String, secret: Key): Claims =
            Jwts.parserBuilder()
                    .setSigningKey(secret)
                    .build()
                    .parseClaimsJws(token)
                    .body

    fun authentication(accessToken: String): Authentication =
            authDetailsService.loadUserByUsername(getTokenBody(accessToken, jwtProperties.accessSecret).subject)
                    .let { UsernamePasswordAuthenticationToken(it, "", it.authorities) }

    fun exactEmailFromRefreshToken(token: String): String =
            getTokenBody(token, jwtProperties.refreshSecret).subject

    fun isRefreshTokenExpired(token: String): Boolean {
        runCatching {
            getTokenBody(token, jwtProperties.refreshSecret).expiration
        }.onFailure {
            return true
        }
        return false
    }

    private fun getAccessTokenExpiredAt(): LocalDateTime =
            LocalDateTime.now().plusSeconds(ACCESS_EXP + 1000)

    private fun generateAccessToken(email: String): String =
            generateToken(email, ACCESS_TYPE, jwtProperties.accessSecret, ACCESS_EXP)

    private fun generateRefreshToken(email: String): String =
            generateToken(email, REFRESH_TYPE, jwtProperties.refreshSecret, REFRESH_EXP)

    private fun generateToken(sub: String, type: String, secret: Key, exp: Long): String =
            Jwts.builder()
                    .signWith(secret, SignatureAlgorithm.HS256)
                    .setSubject(sub)
                    .claim("type", type)
                    .setIssuedAt(Date())
                    .setExpiration(Date(System.currentTimeMillis() * exp * 1000))
                    .compact()

}