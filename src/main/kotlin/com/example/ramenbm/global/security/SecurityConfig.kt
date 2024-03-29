package com.example.ramenbm.global.security

import com.example.ramenbm.domain.user.type.Authority
import com.example.ramenbm.global.security.filter.config.FilterConfig
import com.example.ramenbm.global.security.handler.CustomAccessDeniedHandler
import com.example.ramenbm.global.security.handler.CustomAuthenticationEntryPoint
import com.example.ramenbm.global.security.jwt.TokenParser
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig(
	private val tokenParser: TokenParser,
) {

	@Bean
	protected fun filterChain(http: HttpSecurity): SecurityFilterChain =
		http
			.cors()
			.and()
			.csrf().disable()
			.httpBasic().disable()

			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()

			.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/api/auth/signup").permitAll()
			.antMatchers(HttpMethod.POST, "/api/auth/signin").permitAll()
			.antMatchers(HttpMethod.PATCH, "/api/auth/reissue").permitAll()
			.antMatchers(HttpMethod.POST, "/api/ramen").hasAnyAuthority(Authority.ROLE_USER.name, Authority.ROLE_ADMIN.name)
			.antMatchers(HttpMethod.PATCH, "/api/ramen/{idx}").hasAnyAuthority(Authority.ROLE_USER.name, Authority.ROLE_ADMIN.name)
			.antMatchers(HttpMethod.DELETE, "/api/ramen/{idx}").hasAnyAuthority(Authority.ROLE_USER.name, Authority.ROLE_ADMIN.name)
			.antMatchers(HttpMethod.GET, "/api/ramen").hasAnyAuthority(Authority.ROLE_USER.name, Authority.ROLE_ADMIN.name)
			.antMatchers(HttpMethod.GET, "/api/ramen/{idx}").hasAnyAuthority(Authority.ROLE_USER.name, Authority.ROLE_ADMIN.name)
			.antMatchers(HttpMethod.GET, "/api/user/{idx}").hasAnyAuthority(Authority.ROLE_USER.name, Authority.ROLE_ADMIN.name)
			.antMatchers(HttpMethod.GET, "/api/user/my/ramen").hasAnyAuthority(Authority.ROLE_USER.name, Authority.ROLE_ADMIN.name)

			.anyRequest().permitAll()
			.and()

			.exceptionHandling()
			.accessDeniedHandler(CustomAccessDeniedHandler())
			.and()
			.httpBasic()
			.authenticationEntryPoint(CustomAuthenticationEntryPoint())
			.and()

			.apply(FilterConfig(tokenParser))
			.and()
			.build()

	@Bean
	protected fun passwordEncoder(): PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()

}