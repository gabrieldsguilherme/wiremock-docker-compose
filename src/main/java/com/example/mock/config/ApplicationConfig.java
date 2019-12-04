package com.example.mock.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApplicationConfig {
	
	@Value("${customer-external-service.url}")
	private String customerExternalService;

}
