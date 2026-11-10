package com.engineeringplayground.producer_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engineeringplayground.producer_service.service.ClaimProducerService;

/**
 * This class is a REST controller that handles HTTP requests related to claims.
 * It provides an endpoint to publish claim messages to a Kafka topic using the ClaimProducerService.
 *
 * @author Emmanuel Taylor
 */
@RestController
@RequestMapping("/api/v1/claims")
public class ClaimController {

    private final ClaimProducerService claimProducerService;

    public ClaimController(ClaimProducerService claimProducerService) {
        this.claimProducerService = claimProducerService;
    }
    
    /**
     * Endpoint to publish a claim message to the "claims.submitted" Kafka topic.
     *
     * @param claimJson The claim message in JSON format to be published.
     * @return ResponseEntity indicating the request has been accepted.
     */
    @PostMapping
    public ResponseEntity<Void> publishClaim(@RequestBody String claimJson) {
        claimProducerService.publishClaim(claimJson);
        return ResponseEntity.accepted().build();
    }
}
