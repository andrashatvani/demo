package com.example.event

import com.example.event.BaseEvent.Companion.EVENT_TYPE_HEADER
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.support.SimpleKafkaHeaderMapper

@Configuration
class KafkaEventConfiguration {
    @Bean
    fun defaultKafkaHeaderMapper() = SimpleKafkaHeaderMapper().apply {
        val rawMappedHeaders = HashMap<String, Boolean>()
        rawMappedHeaders[EVENT_TYPE_HEADER] = true
        setRawMappedHeaders(rawMappedHeaders)
    }
}
