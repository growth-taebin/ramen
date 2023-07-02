package com.example.ramenbm.global.security.authentication

import com.example.ramenbm.domain.user.exception.UserNotFoundException
import com.example.ramenbm.domain.user.repository.UserRepository
import com.example.ramenbm.global.annotation.ServiceWithTransaction
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

@ServiceWithTransaction
class AuthDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails =
        userRepository.findByEmail(username)
            .let { it ?: throw UserNotFoundException() }
            .let { AuthDetails(it.email) }

}