package com.example.demo

import com.example.event.EventTypeMapping
import org.springframework.stereotype.Component

@Component
class DummyEventTypeMapping : EventTypeMapping {
    override val supportedEventTypeMap = mapOf(
        DummyEventType.NAME to DummyEvent::class.java,
        DummyAggregatType.NAME to DummyAggregat::class.java
    )
}