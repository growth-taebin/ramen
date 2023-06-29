package com.example.ramenbm.domain.user.repository

import com.example.ramenbm.domain.user.entity.RefreshToken
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository : CrudRepository<RefreshToken, String>