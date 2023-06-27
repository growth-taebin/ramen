package com.example.ramenbm.domain.user.type

import org.springframework.security.core.GrantedAuthority

enum class Authority : GrantedAuthority {
    ROLE_ADMIN, ROLE_USER;

    override fun getAuthority(): String {
        return name
    }

}