package org.polik.reactivekotlinrestapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactiveKotlinRestApiApplication

fun main(args: Array<String>) {
    runApplication<ReactiveKotlinRestApiApplication>(*args)
}
