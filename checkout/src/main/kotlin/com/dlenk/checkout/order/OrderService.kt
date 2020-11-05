package com.dlenk.checkout.order

import org.springframework.stereotype.Service

@Service
class OrderService(val orderRespository: OrderRespository) {
    fun saveOrder(order: Order): Order {
        return orderRespository.save(order)
    }

    fun getOrdersByEmail(email: String): List<Order> {
        return orderRespository.findAllByUserEmail(email)
    }
}