package com.example.demo

import com.example.event.EventTypeMapping
import com.example.event.configuredObjectMapper
import com.fasterxml.jackson.databind.JavaType
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import jakarta.annotation.PostConstruct
import org.rocksdb.RocksDB
import org.springframework.context.ApplicationContext

abstract class BaseApplication(
    private val context: ApplicationContext,
    private val eventTypeMapping: EventTypeMapping,
    objectMapper: ObjectMapper,
) {
    companion object {
        var ID: String = "n/a" // will be overwritten
        var EVENT_TYPE_MAPPING: Map<String, JavaType> = mapOf()
    }

    init {
        RocksDB.loadLibrary()
        objectMapper.apply {
            registerKotlinModule()
            registerModule(JavaTimeModule())
            disable(WRITE_DATES_AS_TIMESTAMPS)
        }
    }

    @PostConstruct
    fun initialize() {
        ID = context.id!!
        EVENT_TYPE_MAPPING = eventTypeMapping.supportedEventTypeMap.mapValues { configuredObjectMapper.constructType(it.value) }
    }
}

