package com.example.HealthService.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HealthService.entity.Health;
import com.example.HealthService.repo.HealthRepositary;
import com.example.HealthService.response.HealthResponse;

@Service
public class HealthService {

	
	@Autowired
	private HealthRepositary repo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public HealthResponse findHealthByAddressId(int addressId) {
		Health health=repo.findHealthByAddressId(addressId);
		HealthResponse healthResponse=modelMapper.map(health, HealthResponse.class);
		return healthResponse;
	}
	
	

}
