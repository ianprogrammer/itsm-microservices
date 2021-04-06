package com.itsm.rabbit


import com.itsm.domain.EventBuilder
import io.micronaut.rabbitmq.annotation.Binding
import io.micronaut.rabbitmq.annotation.RabbitClient

@RabbitClient(value = "\${eventbuilder.exchange}")
interface EventBuilderQueuePublish {
    @Binding("\${eventbuilder.queue}")
    fun send(eventBuilder: EventBuilder)
}