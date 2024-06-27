package com.example.demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.buildAndAwait
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class DummyRouter {

    @Bean
    fun route() = coRouter {
        GET("/") { _ -> ServerResponse.ok().buildAndAwait() }
    }

}

