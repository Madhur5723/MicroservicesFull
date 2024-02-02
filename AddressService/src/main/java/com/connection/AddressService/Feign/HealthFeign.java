package com.connection.AddressService.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.connection.AddressService.response.HealthResponse;



@FeignClient(name="health",url = "http://localhost:8082/health-app/api/hea")
public interface HealthFeign {
	
	@GetMapping("/health/{addressId}")
	public ResponseEntity<HealthResponse> getHealthByAddressId(@PathVariable("addressId") int id);

}
