package com.example.ramenbm.global.security.filter

import com.example.ramenbm.global.exception.RamenException
import com.example.ramenbm.global.exception.enumType.ErrorCode
import com.example.ramenbm.global.exception.response.ErrorResponse
import com.fasterxml.jackson.databind.ObjectMapper
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.JwtException
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class ExceptionHandlerFilter : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        runCatching {
            filterChain.doFilter(request, response)
        }.onFailure { exception ->
            when (exception) {
                is ExpiredJwtException -> setErrorResponse(ErrorCode.ACCESS_TOKEN_EXPIRED, response)
                is JwtException -> setErrorResponse(ErrorCode.INVALID_TOKEN, response)
                is RamenException -> setErrorResponse(exception.errorCode, response)
            }
        }
    }

    private fun setErrorResponse(errorCode: ErrorCode, response: HttpServletResponse) {
        response.status = errorCode.status
        response.contentType = "application/json"
        response.characterEncoding = "utf-8"
        val errorResponseEntityToJson =
            ObjectMapper().writeValueAsString(ErrorResponse(errorCode.message, errorCode.status))
        response.writer.write(errorResponseEntityToJson)
    }

}