package com.engineeringplayground.producer_service.service;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * This class is responsible for producing messages to a Kafka topic.
 * It uses the KafkaTemplate to send messages to the specified topic.
 *
 * @author Emmanuel Taylor
 */
@Slf4j 
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
                        log.error("Failed to publish message: {}", exception);
                    } else {
                        RecordMetadata metadata = result.getRecordMetadata();
                        log.info("Message published successfully. Topic: {}, Partition: {}, Offset: {}",
                            metadata.topic(), metadata.partition(), metadata.offset());
                    }
                }
            );
        } catch (KafkaException e) {
            log.error("Failed to publish message: {}", e);
            throw e;
        }
    }
}
