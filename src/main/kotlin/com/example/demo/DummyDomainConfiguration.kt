package com.example.demo

import com.example.event.BaseEvent
import com.example.event.EventTypeMapping
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DummyDomainConfiguration {

    @Bean
    @ConditionalOnMissingBean
    fun eventTypeMapping() = object : EventTypeMapping {
        override val supportedEventTypeMap = mapOf<String, Class<BaseEvent<*>>>()
    }

}
