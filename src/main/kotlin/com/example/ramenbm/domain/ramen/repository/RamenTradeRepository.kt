package com.example.ramenbm.domain.ramen.repository

import com.example.ramenbm.domain.ramen.entity.RamenTrade
import org.springframework.data.repository.CrudRepository

interface RamenTradeRepository : CrudRepository<RamenTrade, Long> {

	fun findRamenTradeByIdx(idx: Long): RamenTrade?

}