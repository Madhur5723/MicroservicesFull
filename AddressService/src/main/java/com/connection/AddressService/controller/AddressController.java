package com.connection.AddressService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connection.AddressService.response.AddressResponse;
import com.connection.AddressService.service.AddressService;


@RestController
@RequestMapping("/add")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@Autowired
	Environment environment;

	//http://localhost:8081/address-app/api/add/address/1
	@GetMapping("/address/{employeeId}")
	public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeeId") int id){
		System.out.println(environment.getProperty("local.server.port"));
		AddressResponse addressResponse=null;
		addressResponse=addressService.findAddressByEmployeeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
	}

}
