package com.example.ramenbm.global.security.authentication

import com.example.ramenbm.domain.user.type.Authority
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AuthDetails(
	private val email: String
) : UserDetails {
	override fun getAuthorities(): MutableCollection<out GrantedAuthority> =
		mutableListOf(SimpleGrantedAuthority(Authority.ROLE_USER.name))

	override fun getPassword(): String? = null

	override fun getUsername(): String = email

	override fun isAccountNonExpired(): Boolean = false

	override fun isAccountNonLocked(): Boolean = false

	override fun isCredentialsNonExpired(): Boolean = false

	override fun isEnabled(): Boolean = false

}