package com.zenza.teua.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.zenza.teua.infrastructure", "com.zenza.teua.application"])
class TeuaApplication

fun main(args: Array<String>) {
    runApplication<TeuaApplication>(*args)
}