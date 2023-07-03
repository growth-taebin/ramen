package com.example.ramenbm.domain.user.repository

import com.example.ramenbm.domain.user.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {

    fun existsByEmail(email: String): Boolean

    fun findByEmail(email: String): User?

}