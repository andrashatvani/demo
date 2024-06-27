package com.example.event

import com.example.event.BaseEvent

interface EventTypeMapping {
    val supportedEventTypeMap: Map<String, Class<out BaseEvent<*>>>
}


