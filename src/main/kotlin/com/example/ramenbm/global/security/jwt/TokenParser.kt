package com.example.ramenbm.global.security.jwt

import com.example.ramenbm.global.security.authentication.AuthDetailsService
import com.example.ramenbm.global.security.jwt.properties.JwtProperties
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.security.Key
import javax.servlet.http.HttpServletRequest

@Component
class TokenParser(
        private val jwtProperties: JwtProperties,
        private val authDetailsService: AuthDetailsService
) {

    fun parseAccessToken(request: HttpServletRequest): String? =
            request.getHeader("Authorization")
                    .let { it ?: return null }
                    .let { if (it.startsWith(TokenProvider.TOKEN_PREFIX)) it.replace(TokenProvider.TOKEN_PREFIX, "") else null }

    fun parseRefreshToken(token: String): String? =
            if (token.startsWith(TokenProvider.TOKEN_PREFIX)) token.replace(TokenProvider.TOKEN_PREFIX, "") else null

    private fun getTokenBody(token: String, secret: Key): Claims =
            Jwts.parserBuilder()
                    .setSigningKey(secret)
                    .build()
                    .parseClaimsJws(token)
                    .body

    fun authentication(accessToken: String): Authentication =
            authDetailsService.loadUserByUsername(getTokenBody(accessToken, jwtProperties.accessSecret).subject)
                    .let { UsernamePasswordAuthenticationToken(it, "", it.authorities) }

}