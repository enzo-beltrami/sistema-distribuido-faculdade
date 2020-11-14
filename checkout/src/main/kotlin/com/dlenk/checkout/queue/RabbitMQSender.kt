package com.dlenk.checkout.queue

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitTemplate

abstract class RabbitMQSender<T>(
        private val mapper: ObjectMapper,
        private val queue: Queue,
        private val rabbitTemplate: RabbitTemplate
) : QueueSender<T> {
    override fun serialize(obj: T): String {
        return mapper.writeValueAsString(obj)
    }

    override fun send(obj: T) {
        val message = serialize(obj)
        rabbitTemplate.convertAndSend(queue.name, message)
    }
}