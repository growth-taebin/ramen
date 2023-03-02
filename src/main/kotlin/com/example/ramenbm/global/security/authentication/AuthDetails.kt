package com.example.ramenbm.global.security.authentication

import com.example.ramenbm.domain.user.entity.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.Collections

class AuthDetails(
        private val user: User
): UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = Collections.emptyList()

    override fun getPassword(): String? = null

    override fun getUsername(): String = user.email

    override fun isAccountNonExpired(): Boolean = false

    override fun isAccountNonLocked(): Boolean = false

    override fun isCredentialsNonExpired(): Boolean = false

    override fun isEnabled(): Boolean = false
}