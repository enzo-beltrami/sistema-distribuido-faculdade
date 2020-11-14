package com.dlenk.checkout.order

import com.dlenk.checkout.queue.QueueSender
import org.springframework.stereotype.Service

@Service
class OrderService(val orderRespository: OrderRespository, val orderSender: QueueSender<Order>) {
    fun saveOrder(order: Order): Order {
        val orderResponse = orderRespository.save(order)
        orderSender.send(orderResponse)
        return orderResponse
    }

    fun getOrdersByEmail(email: String): List<Order> {
        return orderRespository.findAllByUserEmail(email)
    }
}