package com.example.ramenbm.domain.ramen.entity

import com.example.ramenbm.domain.ramen.presentation.data.dto.UpdateRamenTradeDto
import com.example.ramenbm.domain.user.entity.User
import com.example.ramenbm.global.entity.BaseIdxEntity
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToOne

@Entity
class RamenTrade(
    var title: String,
    var count: Int,
    var price: Int,
    var content: String,
    @ManyToOne(fetch = FetchType.LAZY)
    val user: User
): BaseIdxEntity() {
    fun updateRamenTrade(dto: UpdateRamenTradeDto) {
        this.title = dto.title
        this.count = dto.count
        this.price = dto.price
        this.content = dto.content
    }
}