package com.example.ramenbm.domain.ramen.repository

import com.example.ramenbm.domain.ramen.entity.RamenTrade
import com.example.ramenbm.domain.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface RamenTradeRepository : JpaRepository<RamenTrade, Long> {

	fun findRamenTradeByIdx(idx: Long): RamenTrade?

	fun findRamenTradeByUser(user: User): RamenTrade

}