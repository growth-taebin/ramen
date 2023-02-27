package com.example.ramenbm.global.entity

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class BaseIdxEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idx: Long = 0L
}