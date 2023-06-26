package com.example.ramenbm.domain.ramen.entity

import com.example.ramenbm.global.entity.BaseIdxEntity
import javax.persistence.Entity

@Entity
class Ramen(
    val title: String,
    val count: Int,
    val price: String
): BaseIdxEntity()