package com.dlenk.checkout.queue

interface QueueSender<T> {
    fun serialize(obj: T) : String
    fun send(obj: T)
}