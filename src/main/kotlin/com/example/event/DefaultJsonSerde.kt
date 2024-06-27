package com.example.event

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature.FAIL_ON_EMPTY_BEANS
import com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS
import org.springframework.kafka.support.JacksonUtils
import org.springframework.kafka.support.serializer.JsonSerde

val configuredObjectMapper: ObjectMapper = JacksonUtils.enhancedObjectMapper().apply {
    disable(WRITE_DATES_AS_TIMESTAMPS)
    disable(FAIL_ON_EMPTY_BEANS)
}

/** used in config */
@Suppress("unused")
class DefaultJsonSerde<T> : JsonSerde<T>(configuredObjectMapper)