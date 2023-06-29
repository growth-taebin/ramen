package com.example.ramenbm.global.security

import com.example.ramenbm.domain.user.type.Authority
import com.example.ramenbm.global.security.filter.config.FilterConfig
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
            .antMatchers(HttpMethod.POST, "/auth/signup").permitAll()
            .antMatchers(HttpMethod.POST, "/auth/signin").permitAll()
            .antMatchers(HttpMethod.PATCH, "/auth/reissue").permitAll()
            .antMatchers(HttpMethod.POST, "/api/ramen")
            .hasAnyAuthority(Authority.ROLE_USER.name, Authority.ROLE_ADMIN.name)
            .antMatchers(HttpMethod.PATCH, "/api/ramen/{idx}")
            .hasAnyAuthority(Authority.ROLE_USER.name, Authority.ROLE_ADMIN.name)
            .anyRequest().denyAll()
            .and()
            .apply(FilterConfig(tokenParser))
            .and()
            .build()

    @Bean
    protected fun passwordEncoder(): PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()

}