package com.engineeringplayground.producer_service.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * This class is responsible for producing messages to a Kafka topic.
 * It uses the KafkaTemplate to send messages to the specified topic.
 *
 * @author Emmanuel Taylor
 */
@Service 
public class ClaimProducerService {
    
    private final KafkaTemplate<String, String> kafkaTemplate;

    public ClaimProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Publishes a claim message to the "claims.submitted" Kafka topic.
     *
     * @param claimJson The claim message in JSON format to be published.
     */
    public void publishClaim(String claimJson) {
        kafkaTemplate.send("claims.submitted", claimJson);
    }
}
