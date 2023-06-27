package com.example.ramenbm.domain.ramen.repository

import com.example.ramenbm.domain.ramen.entity.RamenTrade
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

interface RamenTradeRepository: CrudRepository<RamenTrade, Long>