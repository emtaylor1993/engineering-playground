package com.engineeringplayground.producer_service.service;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.KafkaException;
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
     * Publishes a claim message to the "claims.submitted" Kafka topic. It
     * sends the provided claim message in JSON format and logs the result
     * of the operation.
     *
     * @param claimJson The claim message in JSON format to be published.
     */
    public void publishClaim(String claimJson) {
        try {
            kafkaTemplate.send("claims.submitted", claimJson)
                .whenComplete((result, exception) -> {
                    if (exception != null) {
                        System.err.println("Failed to publish message: " + exception.getMessage());
                    } else {
                        RecordMetadata metadata = result.getRecordMetadata();
                        System.out.println("Message published successfully.");
                        System.out.println("Topic: " + metadata.topic());
                        System.out.println("Partition: " + metadata.partition());
                        System.out.println("Offset: " + metadata.offset());
                    }
                }
            );
        } catch (KafkaException e) {
            System.err.println("Failed to publish message: " + e.getMessage());
            throw e;
        }
    }
}
