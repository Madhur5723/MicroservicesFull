package com.connection.Employee.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
	
	private int id;
	private String state;
	private String city;
	private String pincode;
	
}
