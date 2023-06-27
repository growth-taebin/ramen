package com.example.ramenbm.domain.ramen.entity

import com.example.ramenbm.global.entity.BaseIdxEntity
import javax.persistence.Entity

@Entity
class RamenTrade(
    val title: String,
    val count: Int,
    val price: Int
): BaseIdxEntity()