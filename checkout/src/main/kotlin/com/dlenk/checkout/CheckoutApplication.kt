package com.dlenk.checkout

import com.dlenk.checkout.order.OrderRespository
import org.springframework.amqp.core.Queue
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories(basePackages = ["com.dlenk"])
class CheckoutApplication(val orderRepository: OrderRespository) {
    @Value("\${queue.order.name}")
    private lateinit var orderQueue: String

    @Bean
    fun queue(): Queue {
        return Queue(orderQueue, true)
    }
}

fun main(args: Array<String>) {
    runApplication<CheckoutApplication>(*args)
}
