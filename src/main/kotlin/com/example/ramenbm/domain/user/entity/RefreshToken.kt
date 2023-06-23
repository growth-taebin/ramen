package com.example.ramenbm.domain.user.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import java.util.concurrent.TimeUnit


@RedisHash("refresh-token")
data class RefreshToken(
        @Id
        val refreshToken: String,
        val email: String,
        @TimeToLive(unit = TimeUnit.SECONDS)
        val expiredTime: Long
)
