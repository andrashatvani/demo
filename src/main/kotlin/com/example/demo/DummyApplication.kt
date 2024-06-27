package com.example.demo

import com.example.event.EventTypeMapping
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.annotation.PostConstruct
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext

@SpringBootApplication(scanBasePackages = ["com.example"])
class DummyApplication(
    context: ApplicationContext,
    eventTypeMapping: EventTypeMapping,
    objectMapper: ObjectMapper,
) : BaseApplication(
    context = context,
    eventTypeMapping = eventTypeMapping,
    objectMapper = objectMapper
) {
    @PostConstruct
    fun postConstruct() {
        super.initialize()
    }
}

fun main(args: Array<String>) {
    runApplication<DummyApplication>(*args)
}
