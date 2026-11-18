package com.engineeringplayground.consumer_service.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * This class is responsible for consuming messages from a Kafka topic.
 * It listens for messages on the "claims.submitted" topic and logs the
 * received messages.
 *
 * @author Emmanuel Taylor
 */
@Slf4j 
@Service
public class ClaimConsumerService {

    /**
     * Listens for messages on the "claims.submitted" Kafka topic. When a message
     * is received, it logs the content of the message.
     *
     * @param message The message received from the Kafka topic.
     */
    @KafkaListener(topics = "claims.submitted")
    public void listen(String message) {
        log.info("Received message: {}", message);
    }
}
