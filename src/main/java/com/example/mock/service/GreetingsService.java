package com.example.mock.service;

import org.springframework.stereotype.Service;

import com.example.mock.client.ExternalServiceClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GreetingsService {
	
	private final ExternalServiceClient externalServiceClient;
	
	public String getNameByDocument(String document) {
		return externalServiceClient.getCustomerInfo(document)
				.getName();
	}

}
