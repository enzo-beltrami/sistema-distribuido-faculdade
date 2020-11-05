package com.dlenk.checkout.order

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRespository : MongoRepository<Order, String> {
    fun findAllByUserEmail(userEmail: String): List<Order>
}