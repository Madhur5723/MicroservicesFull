package com.empMang.Address.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empMang.Address.entity.Address;
import com.empMang.Address.repositary.AddressRepositary;
import com.empMang.Address.response.AddressResponse;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepositary repo;
	
	@Autowired
	private ModelMapper modelMapper;

	
	public AddressResponse findAddressByEmployeeId(int employeeId) {
		Address address=repo.findAddressByEmployeeId(employeeId);
		AddressResponse addressResponse = modelMapper.map(address, AddressResponse.class);
		
		return addressResponse;
		
	}

}
