package com.dlenk.order;

import com.dlenk.error.NotFoundException;
import com.dlenk.stock.StockService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

  private final StockService stockService;
  private final ObjectMapper mapper;

  public OrderConsumer(StockService stockService, ObjectMapper mapper) {
    this.stockService = stockService;
    this.mapper = mapper;
  }

  @RabbitListener(queues = {"${queue.order.name}"})
  public void receive(@Payload String data) throws JsonProcessingException, NotFoundException {
    OrderModel order = mapper.readValue(data, OrderModel.class);
    stockService.buyFromStock(order.getItemId());
  }
}
