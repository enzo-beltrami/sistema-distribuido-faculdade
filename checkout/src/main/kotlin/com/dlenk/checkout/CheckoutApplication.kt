package com.dlenk.checkout

import com.dlenk.checkout.order.Order
import com.dlenk.checkout.order.OrderRespository
import org.bson.types.ObjectId
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories(basePackages = ["com.dlenk"])
class CheckoutApplication(val orderRepository: OrderRespository) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
//        orderRepository.save(Order(ObjectId(), 5, "aa@gmail.com"))
    }
}

fun main(args: Array<String>) {
    runApplication<CheckoutApplication>(*args)
}
