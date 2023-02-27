package com.example.ramenbm.domain.user.entity

import com.example.ramenbm.global.entity.BaseIdxEntity
import javax.persistence.*

@Entity
class User(
        val email: String,
        val password: String,
        val name: String,
        val discord: String
): BaseIdxEntity()