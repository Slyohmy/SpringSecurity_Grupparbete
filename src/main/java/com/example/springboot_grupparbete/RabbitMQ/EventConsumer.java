package com.example.springboot_grupparbete.RabbitMQ;import org.slf4j.Logger;import org.slf4j.LoggerFactory;public class EventConsumer {  private Logger logger = LoggerFactory.getLogger(EventConsumer.class);  @RabbitListener(queues="orderServiceQueue")  public void receive(String message) {    logger.info("Received message '{}'", message);  }}