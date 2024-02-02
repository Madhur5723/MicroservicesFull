package com.example.HealthService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HealthService.response.HealthResponse;
import com.example.HealthService.service.HealthService;

@RestController
@RequestMapping("/hea")
public class HealthController {

	@Autowired
	private HealthService healthService ;
	
	@Autowired
	Environment environment;

	//http://localhost:8082/health-app/api/hea/health/1
	@GetMapping("/health/{addressId}")
	public ResponseEntity<HealthResponse> getHealthByAddressId(@PathVariable("addressId") int id){
		System.out.println(environment.getProperty("local.server.port"));
		HealthResponse healthResponse=null;
		healthResponse=healthService.findHealthByAddressId(id);
		return ResponseEntity.status(HttpStatus.OK).body(healthResponse);
	}
}
