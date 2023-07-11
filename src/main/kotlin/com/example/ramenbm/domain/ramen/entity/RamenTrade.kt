package com.example.ramenbm.domain.ramen.entity

import com.example.ramenbm.domain.user.entity.User
import com.example.ramenbm.global.entity.BaseIdxEntity
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class RamenTrade(
	var title: String,
	var count: Int,
	var price: Int,
	var content: String,
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_idx")
	val user: User
) : BaseIdxEntity() {

	fun updateRamenTrade(title: String, count: Int, price: Int, content: String) {
		this.title = title
		this.count = count
		this.price = price
		this.content = content
	}

}