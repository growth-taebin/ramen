package com.example.ramenbm.global.security.filter.config

import com.example.ramenbm.global.security.filter.ExceptionHandlerFilter
import com.example.ramenbm.global.security.filter.JwtRequestFilter
import com.example.ramenbm.global.security.jwt.TokenParser
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class FilterConfig(
	private val tokenParser: TokenParser
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain?, HttpSecurity>() {

	override fun configure(builder: HttpSecurity) {
		val jwtRequestFilter = JwtRequestFilter(tokenParser)
		val exceptionHandlerFilter = ExceptionHandlerFilter()
		builder.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter::class.java)
		builder.addFilterBefore(exceptionHandlerFilter, jwtRequestFilter::class.java)
	}

}