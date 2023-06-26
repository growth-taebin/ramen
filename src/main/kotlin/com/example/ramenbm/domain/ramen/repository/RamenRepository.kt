package com.example.ramenbm.domain.ramen.repository

import com.example.ramenbm.domain.ramen.entity.Ramen
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RamenRepository: JpaRepository<Ramen, Long>