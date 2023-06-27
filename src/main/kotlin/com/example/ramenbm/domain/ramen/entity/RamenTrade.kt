package com.example.ramenbm.domain.ramen.entity

import com.example.ramenbm.domain.user.entity.User
import com.example.ramenbm.global.entity.BaseIdxEntity
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToOne

@Entity
class RamenTrade(
    val title: String,
    val count: Int,
    val price: Int,
    val content: String,
    @ManyToOne(fetch = FetchType.LAZY)
    val user: User
): BaseIdxEntity()