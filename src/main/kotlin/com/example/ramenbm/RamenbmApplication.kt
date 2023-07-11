package com.example.ramenbm

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class RamenbmApplication

fun main(args: Array<String>) {
	runApplication<RamenbmApplication>(*args)
}
