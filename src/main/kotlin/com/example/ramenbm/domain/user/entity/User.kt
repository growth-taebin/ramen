package com.example.ramenbm.domain.user.entity

import com.example.ramenbm.global.entity.BaseIdxEntity
import javax.persistence.*

@Entity
class User(
        var email: String,
        var password: String,
        var name: String,
        var discord: String
): BaseIdxEntity()