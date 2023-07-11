package com.example.ramenbm.global.annotation

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Target(AnnotationTarget.CLASS)
@Service
@Transactional(rollbackFor = [Exception::class])
annotation class ServiceWithTransaction
