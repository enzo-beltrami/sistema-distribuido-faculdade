package com.dlenk.checkout.order

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/order")
class OrderController(val orderService: OrderService) {
    @GetMapping
    fun getOrdersByUserEmail(@RequestParam("email") email: String): List<Order> {
        return orderService.getOrdersByEmail(email)
    }

    @PostMapping
    fun saveOrder(orderDTO: OrderDTO): Order {
        return orderService.saveOrder(orderDTO.toOrder())
    }
}