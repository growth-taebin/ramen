package com.example.ramenbm.domain.ramen.repository

import com.example.ramenbm.domain.ramen.entity.RamenTrade
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RamenTradeRepository: JpaRepository<RamenTrade, Long>