package com.engineeringplayground.consumer_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the Consumer Service Spring Boot application.
 * It initializes and runs the application, enabling it to listen for messages
 * on the specified Kafka topic.
 *
 * @author Emmanuel Taylor
 */
@SpringBootApplication
public class ConsumerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerServiceApplication.class, args);
	}
}
