package com.example.mock.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mock.json.GreetingsResponse;
import com.example.mock.service.GreetingsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GreetingsController {
	
	private final GreetingsService greetingsService;
	
	@GetMapping("/greetings")
	public ResponseEntity<GreetingsResponse> greetings(@RequestParam String document) {
		String name = greetingsService.getNameByDocument(document);
		return ResponseEntity.ok(new GreetingsResponse("Hello, " + name));
	}

}
