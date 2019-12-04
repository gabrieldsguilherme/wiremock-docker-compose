package com.example.mock.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.example.mock.config.ApplicationConfig;
import com.example.mock.exception.CustomerInfoException;
import com.example.mock.json.CustomerInfoResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExternalServiceClient {
	
	private final RestTemplate restTemplate;
	private final ApplicationConfig applicationConfig;
	
	public CustomerInfoResponse getCustomerInfo(String document) {
		try {
			ResponseEntity<CustomerInfoResponse> responseEntity = restTemplate
					.getForEntity(applicationConfig.getCustomerExternalService(), CustomerInfoResponse.class, document);
			return responseEntity.getBody();
		} catch (HttpStatusCodeException e) {
			log.error("Error calling external Customer API! HTTP Status: {} Response Body: {}", 
					e.getStatusCode(), e.getResponseBodyAsString(), e);
			throw new CustomerInfoException(e);
		}
	}

}
