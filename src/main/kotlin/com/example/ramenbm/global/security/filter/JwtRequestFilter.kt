package com.example.ramenbm.global.security.filter

import com.example.ramenbm.global.security.jwt.TokenParser
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtRequestFilter(
        private val tokenParser: TokenParser
): OncePerRequestFilter() {

    override fun doFilterInternal(
            request: HttpServletRequest,
            response: HttpServletResponse,
            filterChain: FilterChain
    ) {
        val accessToken = tokenParser.parseAccessToken(request)
        if (!accessToken.isNullOrBlank()) {
            val authentication = tokenParser.authentication(accessToken)
            val securityContext = SecurityContextHolder.getContext()
            securityContext.authentication = authentication
        }
        filterChain.doFilter(request, response)
    }


}