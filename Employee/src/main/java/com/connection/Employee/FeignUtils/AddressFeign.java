package com.connection.Employee.FeignUtils;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.connection.Employee.Response.AddressResponse;

@FeignClient(name="address",url = "http://localhost:8081/address-app/api/add")
public interface AddressFeign {
	
	@GetMapping("/address/{employeeId}")
	public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeeId") int id);

}
