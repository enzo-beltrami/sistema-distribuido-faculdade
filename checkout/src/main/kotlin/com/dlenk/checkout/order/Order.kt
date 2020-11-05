package com.dlenk.checkout.order

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Order(
        @Id
        val id: ObjectId?,
        val itemId: Int,
        val userEmail: String
)

data class OrderDTO(
        val itemId: Int,
        val userEmail: String
) {
        fun toOrder(): Order {
                return Order(null, itemId, userEmail)
        }
}