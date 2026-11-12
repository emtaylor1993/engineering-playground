package com.engineeringplayground.producer_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.KafkaException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler for the application. This class is annotated with
 * @RestControllerAdvice, which allows it to handle exceptions thrown by
 * controller methods across the entire application.
 *
 * @author Emmanuel Taylor
 */
@RestControllerAdvice 
public class GlobalExceptionHandler {
    
    /**
     * Handles KafkaException thrown during Kafka operations. When a
     * KafkaException is caught, this method returns a ResponseEntity with
     * an appropriate error message and HTTP status code.
     *
     * @param ex The KafkaException that was thrown.
     * @return A ResponseEntity containing the error message and HTTP status.
     */
    @ExceptionHandler(KafkaException.class)
    public ResponseEntity<String> handleKafkaException(KafkaException ex) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
            .body("Claim publishing is temporarily unavailable. Please try again later.");
    }
}
