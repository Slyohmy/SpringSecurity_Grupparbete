package com.example.springboot_grupparbete.RabbitMQ;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("!test")
@Service
public class RabbitWorkerService {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void sendJob(String info) throws Exception {
        System.out.println("Sending job to worker.");
        //var job = new BatchProperties.Job("Test", 555);
        //var payload = objectMapper.writeValueAsBytes(job);
        byte[] payload = info.getBytes();
        rabbitTemplate.convertAndSend(RabbitService.exchangeName, "mailservice.job",payload);
    }

}