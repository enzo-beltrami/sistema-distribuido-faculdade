package com.dlenk.checkout.queue

import com.dlenk.checkout.order.Order
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
class OrderSender(
        mapper: ObjectMapper,
        queue: Queue,
        rabbitTemplate: RabbitTemplate
) : RabbitMQSender<Order>(mapper, queue, rabbitTemplate)