package com.example.ramenbm.domain.user.repository

import com.example.ramenbm.domain.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {

    fun existsByEmail(email: String): Boolean

}