package com.engineeringplayground.producer_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the Producer Service application. This class is
 * annotated with @SpringBootApplication, which enables component scanning,
 * auto-configuration, and property support.
 *
 * @author Emmanuel Taylor
 */
@SpringBootApplication
public class ProducerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerServiceApplication.class, args);
	}
}
