package com.connection.AddressService.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.connection.AddressService.Feign.HealthFeign;
import com.connection.AddressService.entity.Address;
import com.connection.AddressService.repo.AddressRepo;
import com.connection.AddressService.response.AddressResponse;
import com.connection.AddressService.response.HealthResponse;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepo repo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private HealthFeign feign;
	

	public AddressResponse findAddressByEmployeeId(int employeeId) {
		
		
		Address address=repo.findAddressByEmployeeId(employeeId);
		
		AddressResponse addressResponse = modelMapper.map(address, AddressResponse.class);
		ResponseEntity<HealthResponse> healthResponseEntity=feign.getHealthByAddressId(employeeId);
		HealthResponse healthResponse = healthResponseEntity.getBody();
		addressResponse.setHealthResponse(healthResponse);
		return addressResponse;
	}

	

}
