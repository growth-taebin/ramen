package com.example.ramenbm.global.security.jwt.properties

import io.jsonwebtoken.security.Keys
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import java.nio.charset.StandardCharsets
import java.security.Key

@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
class JwtProperties(
    accessKey: String,
    refreshKey: String
) {

    val accessSecret: Key = Keys.hmacShaKeyFor(accessKey.toByteArray(StandardCharsets.UTF_8))
    val refreshSecret: Key = Keys.hmacShaKeyFor(refreshKey.toByteArray(StandardCharsets.UTF_8))

}